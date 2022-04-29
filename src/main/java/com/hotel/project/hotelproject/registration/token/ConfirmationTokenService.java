package com.hotel.project.hotelproject.registration.token;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
	
	private ConfirmationTokenRepository confirmationTokenRepository;
	
	@Autowired
	public ConfirmationTokenService(ConfirmationTokenRepository confirmationTokenRepository) {
		super();
		this.confirmationTokenRepository = confirmationTokenRepository;
	}


	public void saveConfirmationToken( ConfirmationToken token ) {
		confirmationTokenRepository.save( token );
	}
	
	public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }

}
