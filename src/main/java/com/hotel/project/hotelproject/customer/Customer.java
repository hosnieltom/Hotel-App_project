package com.hotel.project.hotelproject.customer;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table
public class Customer {
	
	@Id
	@SequenceGenerator(
	name = "customer_sequence",
	sequenceName = "customer_sequence",
	allocationSize = 1
	)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator ="customer_sequence"
			)

	private long id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String country;
	private String email;
    private long phone;
    
	public Customer() {
		
	}

	public Customer(long id, String firstName, String lastName, String address, 
			String city, String country, String email, long phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.email = email;
		this.phone = phone;
	}

	public Customer(String firstName, String lastName, String address, String city,
			String country,String email, long phone ) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.email = email;
		this.phone = phone;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", city=" + city + ", country=" + country + ", email=" + email + ", phone=" + phone + "]";
	}




}
