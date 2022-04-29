package com.hotel.project.hotelproject.login;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotel.project.hotelproject.registration.token.ConfirmationToken;
import com.hotel.project.hotelproject.registration.token.ConfirmationTokenService;
import com.hotel.project.hotelproject.user.User;
import com.hotel.project.hotelproject.user.UserRepository;
import com.hotel.project.hotelproject.user.UserService;

@Service
public class LoginService {
	/*
	private UserService userService;
	private  UserRepository userRepository;
	private BCryptPasswordEncoder  bCryptPasswordEncoder;
	private ConfirmationTokenService confirmationTokenService;

	
	@Transactional
    public String confirmToken(String token) {
		User user = new User();
		
       boolean isUserExists = userRepository.findByEmail( user.getEmail() ).isPresent();
		
		if( isUserExists ) {
			throw new IllegalStateException( "User not found" );
		}
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));


        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(
                confirmationToken.getUser().getEmail());
        return "confirmed";
    }
    */
}
