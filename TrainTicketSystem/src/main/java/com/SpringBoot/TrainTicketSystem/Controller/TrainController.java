package com.SpringBoot.TrainTicketSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.TrainTicketSystem.Entity.Train;
import com.SpringBoot.TrainTicketSystem.Service.TrainService;

import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    // Method to get all trains between two stations
    @GetMapping("/searchtrain")
    public ResponseEntity<List<Train>> getTrainsBetweenStations(@RequestParam String source,
                                                                @RequestParam String destination) {
        // Fetch the trains between the two stations from the service
        List<Train> trains = trainService.getTrainsBetweenStations(source, destination);

        if (trains.isEmpty()) {
            return ResponseEntity.noContent().build(); // If no trains found, return 204 No Content
        }

        return ResponseEntity.ok(trains);
    }
}
