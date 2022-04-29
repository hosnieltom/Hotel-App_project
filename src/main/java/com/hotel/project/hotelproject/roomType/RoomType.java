package com.hotel.project.hotelproject.roomType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class RoomType {
	
	@Id
	@SequenceGenerator(
			name = "room_type_sequence",
			sequenceName = "room_type_sequence",
			allocationSize = 1
			)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "room_type_sequence"
			)
	
	private long id;
	private String requirements;
	private int capacity;
	
	public RoomType() {
		
	}

	public RoomType(long id, String requirements, int capacity) {
		super();
		this.id = id;
		this.requirements = requirements;
		this.capacity = capacity;
	}

	public RoomType(String requirements, int capacity) {
		super();
		this.requirements = requirements;
		this.capacity = capacity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "RoomType [id=" + id + ", requirements=" + requirements + ", capacity=" + capacity + "]";
	}
	
}
