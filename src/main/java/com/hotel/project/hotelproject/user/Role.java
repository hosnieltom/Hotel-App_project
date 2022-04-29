package com.hotel.project.hotelproject.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(nullable = false, length = 45)
    private String name;

	public Role(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

	public Role(Long id) {
		super();
		this.id = id;
	}
	
	
	public Role(String name) {
		super();
		this.name = name;
	}


	public Role() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	
	
	  

}
