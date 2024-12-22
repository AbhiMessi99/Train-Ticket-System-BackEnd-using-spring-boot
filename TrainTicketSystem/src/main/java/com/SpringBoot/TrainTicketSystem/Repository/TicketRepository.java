package com.SpringBoot.TrainTicketSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.TrainTicketSystem.Entity.Ticket;
import com.SpringBoot.TrainTicketSystem.Entity.TrainUser;



@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByUser(TrainUser user);
}
