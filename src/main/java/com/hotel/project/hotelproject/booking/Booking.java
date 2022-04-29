package com.hotel.project.hotelproject.booking;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Booking {
	
	@Id
	@SequenceGenerator(
			name = "booking_sequence",
			sequenceName = "booking_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "booking_sequence" )
	private long id;
	private LocalDate startDate;
	private LocalDate endDate;
	private int numberOfAdults;//number of adults
	private int numberOfChildern;//number of children 
	//room_id
	//staff_id
	//private  int customerId;//customer_id
	

	public Booking() {
		super();
	}

	public Booking(long id, LocalDate startDate, LocalDate endDate,
			int numberOfAdults, int numberOfChildern) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberOfAdults = numberOfAdults;
		this.numberOfChildern = numberOfChildern;
		//this.customerId = customerId;
	}

	public Booking( LocalDate startDate, LocalDate endDate, int numberOfAdults,
			int numberOfChildern) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberOfAdults = numberOfAdults;
		this.numberOfChildern = numberOfChildern;
		//this.customerId = customerId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	

	public int getNumberOfAdults() {
		return numberOfAdults;
	}

	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}

	public int getNumberOfChildern() {
		return numberOfChildern;
	}

	public void setNumberOfChildern(int numberOfChildern) {
		this.numberOfChildern = numberOfChildern;
	}
 /*
	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	*/

	@Override
	public String toString() {
		return "Booking [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", numberOfAdults=" + numberOfAdults + ", numberOfChildern="
				+ numberOfChildern + "]";
	}

	
}
