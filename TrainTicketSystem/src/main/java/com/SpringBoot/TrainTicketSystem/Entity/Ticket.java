package com.SpringBoot.TrainTicketSystem.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TrainUser user;

    @ManyToOne
    private Train train;

    @Column(nullable = false)
    private int seatsBooked;

    @ElementCollection
    @CollectionTable(name = "ticket_passenger_names", joinColumns = @JoinColumn(name = "ticket_id"))
    @Column(name = "passenger_name")
    private List<String> passengerNames = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TrainUser getUser() {
		return user;
	}

	public void setUser(TrainUser user) {
		this.user = user;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public List<String> getPassengerNames() {
		return passengerNames;
	}

	public void setPassengerNames(List<String> passengerNames) {
		this.passengerNames = passengerNames;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", user=" + user + ", train=" + train + ", seatsBooked=" + seatsBooked
				+ ", passengerNames=" + passengerNames + "]";
	}

	public Ticket(Long id, TrainUser user, Train train, int seatsBooked, List<String> passengerNames) {
		super();
		this.id = id;
		this.user = user;
		this.train = train;
		this.seatsBooked = seatsBooked;
		this.passengerNames = passengerNames;
	}

    public Ticket() {
    	
    }
}

