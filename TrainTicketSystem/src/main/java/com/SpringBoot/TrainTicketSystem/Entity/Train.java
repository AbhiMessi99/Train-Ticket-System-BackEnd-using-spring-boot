package com.SpringBoot.TrainTicketSystem.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String trainName;

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private int seatsAvailable;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public Train(Long id, String trainName, String source, String destination, int seatsAvailable) {
		super();
		this.id = id;
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.seatsAvailable = seatsAvailable;
	}
	
	public Train() {
		
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", trainName=" + trainName + ", source=" + source + ", destination=" + destination
				+ ", seatsAvailable=" + seatsAvailable + "]";
	}

    
}
