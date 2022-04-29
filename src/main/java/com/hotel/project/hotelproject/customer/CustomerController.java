package com.hotel.project.hotelproject.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//To allow other access this end-point
@CrossOrigin 
//@RequestMapping( path = "/customers" )
@RequestMapping( path = "/api/1.0")
public class CustomerController {
	
	private final CustomerService customerService;
	
	@Autowired
	public CustomerController( CustomerService customerService )  {
		super();
		this.customerService = customerService;
	}


	
	@GetMapping( path = "/customers")
	public List<Customer> getAllCustomers()
	{
		return customerService.getAllCustomers();
	}
	
	@PostMapping(path = "/customer")
	public void registerNewCustomer( @RequestBody Customer customer )
	{
		customerService.addNewCustomer( customer );
		
	}
	
	@DeleteMapping( path = "{customerId}" )
	public void deleteCustomer( @PathVariable( "customerId")  Long customerId ) {
		customerService.deleteCustomer( customerId );
		
	}
	
	@PutMapping( path = "{customerId}" )
	public void updateCustomer( @PathVariable( "customerId" ) long customerId,
			@RequestParam( required = false ) String firstName,
			@RequestParam( required = false ) String email) {
		customerService.updateCustomer( customerId, firstName, email );
		
	}

}
