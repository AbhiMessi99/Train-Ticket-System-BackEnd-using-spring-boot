package com.SpringBoot.TrainTicketSystem.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.TrainTicketSystem.Entity.TrainUser;

@Repository // Optional: Spring will detect this automatically if it's a Spring-managed component
public interface UserRepository extends JpaRepository<TrainUser, Long> {
    // Custom query method to find a user by username
    Optional<TrainUser> findByUsername(String username);
    boolean existsByUsername(String username);
}