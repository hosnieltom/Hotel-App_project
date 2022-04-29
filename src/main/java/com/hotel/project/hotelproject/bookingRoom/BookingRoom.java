package com.hotel.project.hotelproject.bookingRoom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class BookingRoom {
	// cancellation table 
	// cancellationBooking
	// booing_id
	// cancellationDate
	//reason 
	
	// recovery if i need 
	
	//books
	//id
	//title
	//pageNumbe
	//location
	//author
	
	
	@Id
	@SequenceGenerator(
			name = "booking_room_sequence",
			sequenceName = "booking_room_sequence",
			allocationSize = 1
			)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "booking_room_sequence"
			)
	
	private long id;
	private int numberOfRoom;
	private String status;
	private int bookingId;
	private int roomTypeId;
	
	public BookingRoom() {
		
	}

	public BookingRoom(long id, int numberOfRoom, String status, int bookingId, int roomTypeId) {
		super();
		this.id = id;
		this.numberOfRoom = numberOfRoom;
		this.status = status;
		this.bookingId = bookingId;
		this.roomTypeId = roomTypeId;
	}

	public BookingRoom(int numberOfRoom, String status, int bookingId, int roomTypeId) {
		super();
		this.numberOfRoom = numberOfRoom;
		this.status = status;
		this.bookingId = bookingId;
		this.roomTypeId = roomTypeId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumberOfRoom() {
		return numberOfRoom;
	}

	public void setNumberOfRoom(int numberOfRoom) {
		this.numberOfRoom = numberOfRoom;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	@Override
	public String toString() {
		return "BookingRoom [id=" + id + ", numberOfRoom=" + numberOfRoom + ", status=" + status + ", bookingId="
				+ bookingId + ", roomTypeId=" + roomTypeId + "]";
	}
	
	
}
