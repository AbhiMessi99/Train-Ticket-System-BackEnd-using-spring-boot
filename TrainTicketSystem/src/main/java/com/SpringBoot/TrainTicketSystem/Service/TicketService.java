package com.SpringBoot.TrainTicketSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.TrainTicketSystem.Entity.Ticket;
import com.SpringBoot.TrainTicketSystem.Entity.Train;
import com.SpringBoot.TrainTicketSystem.Entity.TrainUser;
import com.SpringBoot.TrainTicketSystem.Repository.TicketRepository;
import com.SpringBoot.TrainTicketSystem.Repository.TrainRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TrainRepository trainRepository;

    public Ticket bookTicket(Long trainId, int seats, TrainUser user, List<String> passengerNames) {
        // Validate train existence
        Train train = trainRepository.findById(trainId)
                .orElseThrow(() -> new RuntimeException("Train with ID " + trainId + " not found"));

        // Check if sufficient seats are available
        if (train.getSeatsAvailable() < seats) {
            throw new RuntimeException("Not enough seats available on Train ID: " + trainId);
        }

        // Deduct the seats from the train
        train.setSeatsAvailable(train.getSeatsAvailable() - seats);
        trainRepository.save(train);

        // Create the ticket
        Ticket ticket = new Ticket();
        ticket.setTrain(train);
        ticket.setUser(user);
        ticket.setSeatsBooked(seats);
        ticket.setPassengerNames(passengerNames);

        // Save the ticket
        return ticketRepository.save(ticket);
    }

    public void cancelTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket with ID " + ticketId + " not found"));

        // Add the canceled seats back to the train's available seats
        Train train = ticket.getTrain();
        train.setSeatsAvailable(train.getSeatsAvailable() + ticket.getSeatsBooked());
        trainRepository.save(train);

        // Delete the ticket
        ticketRepository.delete(ticket);
    }
    
    public List<Ticket> getTicketsByUser(TrainUser user) {
        return ticketRepository.findByUser(user);
    }
}



