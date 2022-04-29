package com.hotel.project.hotelproject.login;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.project.hotelproject.security.config.JWTTokenHelper;
import com.hotel.project.hotelproject.user.User;


@CrossOrigin(origins = "*")
@RestController
//@RequestMapping( path = "/api/1.0")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTTokenHelper jwtToken;
	
	//@PostMapping(path ="/login")
	@RequestMapping( value = "/api/1.0/login", method = RequestMethod.POST )
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception {
		
		try {
			final Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
			
		}
		
		catch ( BadCredentialsException e){
			throw new Exception("Incorrect username or password",e);
		}
		
		
		final UserDetails userDeatils = userDetailsService.loadUserByUsername( loginRequest.getEmail() );
		
		final String jwt = jwtToken.generateToken(userDeatils);
		 
		return ResponseEntity.ok( new LoginResponse( jwt ));
	}
	
	/*
	@GetMapping(path ="/login")
	public String login() {
		
		return "login";
	}
	
	//@PostMapping(path ="/login")
	@RequestMapping( value = "/api/1.0/login", method = RequestMethod.POST )
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication( authentication );
		
		//User user = (User)authentication.getPrincipal();
		User user=(User)authentication.getPrincipal();
		/*
		String jwtToken=jWTTokenHelper.generateToken(user.getUsername());
		
		LoginResponse response=new LoginResponse();
		response.setToken(jwtToken);
		

		return ResponseEntity.ok(response);
		
		
		return "Login";
	}
	*/
	

}
