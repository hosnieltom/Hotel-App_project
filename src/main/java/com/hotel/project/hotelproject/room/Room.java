package com.hotel.project.hotelproject.room;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;
@Entity
@Table
public class Room {
	
	@Id
	@SequenceGenerator(
			name = "room_sequence",
			sequenceName = "room_sequence",
			allocationSize = 1
			)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "room_sequence"
			)
	
	private long id;
	private String roomNumber;
	//private int roomTypeId;
	//private String status; // cancelled/confirmed
	private double cost;
	private String requirements;
	private int capacity;
	//@Column(columnDefinition = "MEDIUMBLOB")
	@Column(nullable = true, length = 128)
    private String image; 
	//booking_id
	
	
	public String getImage() {
		return image;
	}

	public void setImage( String image ) {
		this.image = image;
	}

	public Room() {
		
	}

	public Room(long id, String roomNumber, double cost,
			String requirements, int capacity, String image) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		//this.roomTypeId = roomTypeId;
		//this.status = status;
		this.cost = cost;
		this.requirements = requirements;
		this.capacity = capacity;
		this.image = image;
	}


	public Room(String roomNumber, double cost, 
			String requirements, int capacity, String image) {
		super();
		this.roomNumber = roomNumber;
		//this.roomTypeId = roomTypeId;
		//this.status = status;
		this.cost = cost;
		this.requirements = requirements;
		this.capacity = capacity;
		this.image = image;
	}
	
	@Transient
    public String getPhotosImagePath() {
        if ( image == null || id == 0 ) return null;
         
        return "/room-images/" + id + "/" + image;
    }


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	

	public String getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}


	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNumber=" + roomNumber + ", roomTypeId=" 
				+ ", cost=" + cost + ", requirements=" + requirements + ", capacity=" + capacity + ", image=" + image
				+ "]";
	}
	
}
