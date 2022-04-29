package com.hotel.project.hotelproject.customer;

import java.util.Optional;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long> {
	
	//@Query(" SELECT s FROM Student s WHERE s.email=?1")
		Optional<Customer> findCustomerByEmail( String email );
		
		// another solution 
		/*
		@PersistenceContext
		EntityManager manager
		public Customer findByEmail( String e) {
			return manager.find(Customer.class, e);
			
		}*/
		
	

}
