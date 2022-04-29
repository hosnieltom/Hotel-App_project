package com.hotel.project.hotelproject.staff;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Staff {
	
	@Id
	@SequenceGenerator(
			name = "staff_sequence",
			sequenceName = "staff_sequence",
			allocationSize = 1 )
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "staff_sequence" )
	
	
	private long Id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	
	public Staff() {
		super();
	}


	public Staff(long id, String firstName, String lastName, String email, String password ) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}


	public Staff(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Staff [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
}
