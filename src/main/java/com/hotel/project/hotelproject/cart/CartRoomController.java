package com.hotel.project.hotelproject.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.project.hotelproject.user.User;
@CrossOrigin
@RestController
@RequestMapping( path = "/api/1.0")
//@Controller
public class CartRoomController {
	

	@Autowired
	private CartRoomService cartRoomService;
	
	//private User user;
	
	@Autowired
	public CartRoomController(CartRoomService cartRoomService) {
		super();
		this.cartRoomService = cartRoomService;
		//this.user = user;
	}




	@GetMapping( path = "/cart" )
	public String showRoomCart( Model model, @AuthenticationPrincipal Authentication authentication) {
		
		//User user1 = new User()
;		
		//List<CartRoom> cartRooms = cartRoomService.listCartRooms(user1);
		
		//model.addAttribute("cartRooms", cartRooms);
		
		return "rooms_cart";
	}

}
