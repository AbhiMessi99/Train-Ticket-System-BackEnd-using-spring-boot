package com.SpringBoot.TrainTicketSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.TrainTicketSystem.Entity.Train;
import com.SpringBoot.TrainTicketSystem.Repository.TrainRepository;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    // Method to get trains between two stations (source and destination)
    public List<Train> getTrainsBetweenStations(String source, String destination) {
        return trainRepository.findBySourceAndDestination(source, destination);
    }
}
