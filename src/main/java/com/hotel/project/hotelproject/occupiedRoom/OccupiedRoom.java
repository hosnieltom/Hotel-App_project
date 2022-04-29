package com.hotel.project.hotelproject.occupiedRoom;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class OccupiedRoom {
	
	@Id
	@SequenceGenerator(
			name = "occupied_room_sequence",
			sequenceName = "occupied_room_sequence",
			allocationSize = 1
			)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "occupied_room_sequence"
			)
	
	private long id;
	private  Timestamp check_in;
	private  Timestamp check_out;
	private long bookingId;
	private long roomId;
	
	public OccupiedRoom() {
		
	}

	public OccupiedRoom(long id, Timestamp check_in, Timestamp check_out, long bookingId, long roomId) {
		super();
		this.id = id;
		this.check_in = check_in;
		this.check_out = check_out;
		this.bookingId = bookingId;
		this.roomId = roomId;
	}

	public OccupiedRoom(Timestamp check_in, Timestamp check_out, long bookingId, long roomId) {
		super();
		this.check_in = check_in;
		this.check_out = check_out;
		this.bookingId = bookingId;
		this.roomId = roomId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getCheck_in() {
		return check_in;
	}

	public void setCheck_in(Timestamp check_in) {
		this.check_in = check_in;
	}

	public Timestamp getCheck_out() {
		return check_out;
	}

	public void setCheck_out(Timestamp check_out) {
		this.check_out = check_out;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	@Override
	public String toString() {
		return "OccupiedRoom [id=" + id + ", check_in=" + check_in + ", check_out=" + check_out + ", bookingId="
				+ bookingId + ", roomId=" + roomId + "]";
	}
	
	
	
	

}
