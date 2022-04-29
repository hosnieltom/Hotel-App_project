package com.hotel.project.hotelproject.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotel.project.hotelproject.registration.token.ConfirmationToken;
import com.hotel.project.hotelproject.registration.token.ConfirmationTokenService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
	 //@Autowired
	private  UserRepository userRepository;
	private BCryptPasswordEncoder  bCryptPasswordEncoder;
	private ConfirmationTokenService confirmationTokenService;
	private RoleRepository roleRepository;
	private final String USER_NOT_FOUND_MSG = "User with email emai %s not found";
	
	
	@Autowired
	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
			ConfirmationTokenService confirmationTokenService,RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.confirmationTokenService = confirmationTokenService;
		this.roleRepository = roleRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String email ) throws UsernameNotFoundException {
		
		return userRepository.findByEmail( email ).orElseThrow( () -> 
		new UsernameNotFoundException( String.format( USER_NOT_FOUND_MSG,email )));
	}
	
	
	public String signUpUser ( User user ) {
		
		boolean isUserExists = userRepository.findByEmail( user.getEmail() ).isPresent();
		
		if( isUserExists ) {
			throw new IllegalStateException( "Email is already taken" );
		}
		
		String encodedPassword = bCryptPasswordEncoder.encode( user.getPassword());
		user.setPassword( encodedPassword );
		
		Role roleUser = roleRepository.findByName("User");
		
		user.addRole(roleUser);
		
		userRepository.save( user );
		
		String token = UUID.randomUUID().toString();
		ConfirmationToken confirmationToken = new ConfirmationToken(
				token,
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15),
				user
				);
		
		confirmationTokenService.saveConfirmationToken( confirmationToken );
		
		//Send Email
		
		return token;
		//return "It works";
	}
	public int enableUser(String email) {
        return userRepository.enableUser(email);
    }
	
	public void saveUser( User user ) {
		
		String encodedPassword = bCryptPasswordEncoder.encode( user.getPassword());
		user.setPassword( encodedPassword );
		
		userRepository.save( user );
		
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Optional<User> getUser( long userId) {
		boolean exists = userRepository.existsById( userId);
		
		if( !exists )
		{
			throw new IllegalStateException(
					"user with id" + userId + "does not exists" );
		}
		
		return userRepository.findById( userId);
		
	}
	/*
	public User getUser( long id ) {
		return userRepository.findById( id).get();
	}
	*/
	
	public List<Role> getAllRoles(){
		return roleRepository.findAll();
	}
	/*
	// I need to check if to keep this method
	public User getCurrentlyLoginUser( Authentication authentication ) {
		if ( authentication == null) return null;
		
		User user = null;
		
		Object principal = authentication.getPrincipal();
		if( principal instanceof UserService ) {
			user = ((UserService)princaipal)
		}
		
	}
	*/

}
