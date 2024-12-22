package com.SpringBoot.TrainTicketSystem.DTO;

import java.util.List;

public class TicketBookingRequest {

    private Long trainId;
    private int seats;
    private List<String> passengerNames;
    private String username;

    // Getters and setters
    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public List<String> getPassengerNames() {
        return passengerNames;
    }

    public void setPassengerNames(List<String> passengerNames) {
        this.passengerNames = passengerNames;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
