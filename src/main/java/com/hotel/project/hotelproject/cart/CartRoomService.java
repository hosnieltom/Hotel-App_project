package com.hotel.project.hotelproject.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.project.hotelproject.user.User;

@Service
public class CartRoomService {
	
	@Autowired
	private CartRoomRepository cartRoomRepository;
	
	public List<CartRoom> listCartRooms ( User user) {
		return cartRoomRepository.findByUser(user);
	}

}
