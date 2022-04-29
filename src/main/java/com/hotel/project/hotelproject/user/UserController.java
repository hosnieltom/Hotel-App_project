package com.hotel.project.hotelproject.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.project.hotelproject.room.Room;


@RestController
//@CrossOrigin(origins = "*")
@RequestMapping( path = "/api/1.0")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping(path = "/users")
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
		
	}
	@GetMapping( path = "/user/{userId}" )
	public Optional<User> getUser( @PathVariable ( "userId" ) long userId)
	{
		return userService.getUser( userId );
	}
	
	
	@GetMapping( path = "/user/edit/{userId}" )
	public Optional<User> getUser( @PathVariable ( "userId" ) long userId, Model model)
	{
		
		//Optional<User> user = userService.getUser(userId);
		List<Role> allRoles = userService.getAllRoles();
		//model.addAttribute("user", user);
		model.addAttribute("allRoles",allRoles);
		return userService.getUser(userId);
		
	}
	
	@GetMapping(path = "/roles")
	public List<Role> getAllRoles()
	{
		return userService.getAllRoles();
		
	}
	
	
	
	@PostMapping(path = "save/user")
	public void saveUser( @RequestBody User user ) {
		userService.saveUser( user );
	}
	

}
