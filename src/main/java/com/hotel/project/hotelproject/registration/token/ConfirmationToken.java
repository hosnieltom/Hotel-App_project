package com.hotel.project.hotelproject.registration.token;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.project.hotelproject.user.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {
	
	@SequenceGenerator(
			name = "confirmation_token_sequence",
			sequenceName = "confirmation_token_sequence",
			allocationSize = 1 )
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "confirmation_token_sequence" )
	
	private Long id;
	
	@Column( nullable = false)
	private String token;
	
	@Column( nullable = false)
	private LocalDateTime createAt;
	@Column( nullable = false)
	private LocalDateTime expiresAt;
	private LocalDateTime confirmedAt;
	
	//@Autowired
	@ManyToOne
	@JoinColumn(
			nullable = false,
			name = "user_id"
			)
	private User user;
	@Autowired
	public ConfirmationToken(User user) {
		super();
		this.user = user;
	}
	
	public ConfirmationToken(String token, LocalDateTime createAt, LocalDateTime expiredAt,User user) {
		super();
		this.token = token;
		this.createAt = createAt;
		this.expiresAt = expiredAt;
		this.user = user;
		//this.confirmedAt = confirmedAt;
	}
	

	public ConfirmationToken() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}

	public LocalDateTime getConfirmedAt() {
		return confirmedAt;
	}

	public void setConfirmedAt(LocalDateTime confirmedAt) {
		this.confirmedAt = confirmedAt;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
