package com.SpringBoot.TrainTicketSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.TrainTicketSystem.Entity.TrainUser;
import com.SpringBoot.TrainTicketSystem.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<TrainUser> registerUser(@RequestBody TrainUser user) {
        // Set the default role to "USER" (you can also handle more logic in the service layer)
        user.setRole("USER");
        
        // Call the service method to register the user
        TrainUser savedUser = userService.register(user);
        
        // Return the saved user
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @PostMapping("/signin")
    public ResponseEntity<TrainUser> signInUser(@RequestBody TrainUser loginRequest) {
        // Call the service method to validate the user
        try {
        	TrainUser isValidUser = userService.validateUser(loginRequest.getUsername(), loginRequest.getPassword());
        	return ResponseEntity.status(HttpStatus.OK).body(isValidUser);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(null);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<TrainUser> updateUserDetails(@RequestBody TrainUser updatedUser) {
        try {
            // Call the service method to update the user
            TrainUser updated = userService.updateUserDetails(updatedUser);
            updated.setRole("USER");
            // Return the updated user
            return ResponseEntity.status(HttpStatus.OK).body(updated);
        } catch (RuntimeException e) {
            // If user not found, return 404 Not Found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
