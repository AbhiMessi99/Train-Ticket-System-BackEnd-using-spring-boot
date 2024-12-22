package com.SpringBoot.TrainTicketSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.SpringBoot.TrainTicketSystem.Entity.Train;

public interface TrainRepository extends JpaRepository<Train, Long> {

    // Custom query to find all trains between two stations (source and destination)
    @Query("SELECT t FROM Train t WHERE t.source = :source AND t.destination = :destination")
    List<Train> findBySourceAndDestination(String source, String destination);
}
