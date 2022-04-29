package com.hotel.project.hotelproject.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping( path = "/api/1.0")
@AllArgsConstructor
public class UserRegistrationController {
	
	
	private RegistrationService registrationService;
	 
	 
	 @Autowired
	 public UserRegistrationController( RegistrationService registrationService ) {
		super();
		this.registrationService = registrationService;
	}



	@PostMapping(path ="/user")
	public String register( @RequestBody RegistrationRequest request ) {
		return registrationService.register( request );
	}
	
	//public List<User> getAll
	
	@GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
	
	/*
	@GetMapping(path = "login")
	public String login() {
		
		return "login";
	}
	*/

}
