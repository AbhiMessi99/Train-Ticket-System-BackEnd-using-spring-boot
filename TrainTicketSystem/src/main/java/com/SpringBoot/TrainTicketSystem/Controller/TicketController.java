package com.SpringBoot.TrainTicketSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.TrainTicketSystem.DTO.TicketBookingRequest;
import com.SpringBoot.TrainTicketSystem.Entity.Ticket;
import com.SpringBoot.TrainTicketSystem.Entity.TrainUser;
import com.SpringBoot.TrainTicketSystem.Repository.UserRepository;
import com.SpringBoot.TrainTicketSystem.Service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/book")
    public ResponseEntity<Ticket> bookTicket(@RequestBody TicketBookingRequest bookingRequest) {
        // Retrieve user from the username in the DTO
        TrainUser user = userRepository.findByUsername(bookingRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Pass trainId, seats, user, and passengerNames to the TicketService
        Ticket ticket = ticketService.bookTicket(
            bookingRequest.getTrainId(),
            bookingRequest.getSeats(),
            user,
            bookingRequest.getPassengerNames()
        );

        return ResponseEntity.ok(ticket);
    }

    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<String> cancelTicket(@PathVariable Long id) {
        ticketService.cancelTicket(id);
        return ResponseEntity.ok("Ticket canceled successfully");
    }
    
    @GetMapping("/user/{username}")
    public ResponseEntity<List<Ticket>> getTicketsByUser(@PathVariable String username) {
        // Retrieve user by username
        TrainUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Fetch all tickets for the user
        List<Ticket> tickets = ticketService.getTicketsByUser(user);

        return ResponseEntity.ok(tickets);
    }
}
