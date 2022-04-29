package com.hotel.project.hotelproject.cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.project.hotelproject.user.User;

@Repository
public interface CartRoomRepository extends JpaRepository<CartRoom, Long> {
	
	public List<CartRoom> findByUser(User user);	

}
