package com.hotel.project.hotelproject.cart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hotel.project.hotelproject.room.Room;
import com.hotel.project.hotelproject.user.User;

@Entity
@Table
public class CartRoom {
	
	@Id
	@SequenceGenerator(
			name = "cart_room_sequence",
			sequenceName = "cart_room_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "cart_room_sequence" )
	
	private long id;
	
	@ManyToOne
	private Room room;
	
	@ManyToOne
	private User user;
	
	private int quantity;
	
	

	public CartRoom() {
		super();
	}


	public CartRoom(long id, Room room, User user, int quantity) {
		super();
		this.id = id;
		this.room = room;
		this.user = user;
		this.quantity = quantity;
	}
	

	public CartRoom(Room room, User user, int quantity) {
		super();
		this.room = room;
		this.user = user;
		this.quantity = quantity;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "CartRoom [id=" + id + ", room=" + room + ", user=" + user + ", quantity=" + quantity + "]";
	}
	
	
	
	

}
