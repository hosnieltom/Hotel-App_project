package com.hotel.project.hotelproject.hosted;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Hosted {
	
	@Id
	@SequenceGenerator(
			name = "hosted_sequence",
			sequenceName = "hosted_sequence",
			allocationSize = 1
			)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "hosted_sequence"
			)
	
	private long id;
	private long customerId;
	private long occupiedRoomId;
	
	public Hosted() {
		
	}

	public Hosted(long id, long customerId, long occupiedRoomId) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.occupiedRoomId = occupiedRoomId;
	}

	public Hosted(long customerId, long occupiedRoomId) {
		super();
		this.customerId = customerId;
		this.occupiedRoomId = occupiedRoomId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getOccupiedRoomId() {
		return occupiedRoomId;
	}

	public void setOccupiedRoomId(long occupiedRoomId) {
		this.occupiedRoomId = occupiedRoomId;
	}

	@Override
	public String toString() {
		return "Hosted [id=" + id + ", customerId=" + customerId + ", occupiedRoomId=" + occupiedRoomId + "]";
	}
	
}
