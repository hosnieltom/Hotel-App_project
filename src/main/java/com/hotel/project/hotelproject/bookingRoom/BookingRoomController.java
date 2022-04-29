package com.hotel.project.hotelproject.bookingRoom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin 
@RequestMapping( path = "/bookingRooms" )
public class BookingRoomController {
	
	private BookingRoomService bookingRoomService;
	
	@Autowired
	public BookingRoomController(BookingRoomService bookingRoomService) {
		super();
		this.bookingRoomService = bookingRoomService;
	}

	@GetMapping
	public List<BookingRoom> getAllBookingRooms()
	{
		return bookingRoomService.getAllBookingRooms();
	}
	
	@PostMapping
	public void addNewBookingRoom( @RequestBody BookingRoom bookingRoom )
	{
		bookingRoomService.addNewBookingRoom( bookingRoom );
	}
	
	@DeleteMapping( path = "{bookingRoomId}" )
	public void deleteBookingRoom( @PathVariable( "bookingRoomId" ) long bookingRoomId )
	{
		bookingRoomService.deleteBookingRoom( bookingRoomId );
		
	}
	
	@PutMapping( path = "{bookingRoomId}" )
	public void updateBookingRoom( @PathVariable( "bookingRoomId" ) long bookingRoomId,
			@RequestParam( required = false ) int numberOfRooms,
			@RequestParam( required = false ) String status,
			@RequestParam( required = false ) int bookingId,
			@RequestParam( required = false ) int roomTypeId )
	{
		bookingRoomService.updateBookingRoom( bookingRoomId, numberOfRooms, status, bookingId, roomTypeId );
	}

}
