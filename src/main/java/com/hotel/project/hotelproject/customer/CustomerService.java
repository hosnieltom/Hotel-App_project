package com.hotel.project.hotelproject.customer;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	public List<Customer> getAllCustomers()
	{
		return customerRepository.findAll();
				
	}

	public void addNewCustomer(Customer customer) {
		
		Optional<Customer> customerOptional =
				customerRepository.findCustomerByEmail( customer.getEmail() );
		if( customerOptional.isPresent() )
		{
			throw new IllegalStateException( "email taken" );
		}
		
		customerRepository.save( customer );

	}

	public void deleteCustomer( Long customerId ) {
		
		boolean exists = customerRepository.existsById( customerId );
		
		if( !exists )
		{
			throw  new IllegalStateException(
					"customer with id " + customerId + " does not exists");
		}
		customerRepository.deleteById( customerId );
		
	}

    @Transactional 
	public void updateCustomer(long customerId,
			String firstName,
			String email) {
    	Customer customer = customerRepository.findById( customerId )
    			.orElseThrow( () -> new IllegalStateException(
    					"customer with id " + customerId + " does not exists"));
    	
    	if( firstName != null && 
    			firstName.length() > 0 && 
    			!Objects.equals(customer.getFirstName(), firstName)) {
    		customer.setFirstName( firstName );
    	}
    	
    	if( email != null && 
    			email.length() > 0 && 
    			!Objects.equals(customer.getEmail(), email)) {
    		
    		Optional<Customer> customerOptional =
    				customerRepository.findCustomerByEmail( email );
    		if( customerOptional.isPresent() )
    		{
    			throw new IllegalStateException( "email taken" );
    		}
    		customer.setEmail( email );
    	}
		
	}

}
