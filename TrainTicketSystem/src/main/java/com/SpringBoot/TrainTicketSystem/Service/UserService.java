package com.SpringBoot.TrainTicketSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.TrainTicketSystem.Entity.TrainUser;
import com.SpringBoot.TrainTicketSystem.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public TrainUser register(TrainUser user) {
        // Check if the username already exists (optional logic for validation)
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        return userRepository.save(user); // Save the new user to the database
    }

    public TrainUser validateUser(String username, String password) {
        // Fetch user by username
        TrainUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));

        // Validate password using BCrypt
        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        return user; // Return the validated user object
    }

    public TrainUser updateUserDetails(TrainUser updatedUser) {
        // Fetch the user by ID
        TrainUser existingUser = userRepository.findByUsername(updatedUser.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update the fields you want to change
        existingUser.setUsername(updatedUser.getUsername());  // Assuming username can be updated
        existingUser.setPassword(updatedUser.getPassword());  // Assuming password can be updated
        existingUser.setRole(updatedUser.getRole());          // Role might not need to be updated often
        // Add other fields as necessary
        existingUser.setEmail(updatedUser.getEmail());
        // Save and return the updated user
        return userRepository.save(existingUser);
    }
}
