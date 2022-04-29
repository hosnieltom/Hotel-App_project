package com.hotel.project.hotelproject.booking;

import java.time.LocalDate;
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
@RequestMapping( path = "/api/1.0")
public class BookingController {
	
	private BookingService bookingService;
	
	@Autowired
	public BookingController(BookingService bookingService, List<Booking> list) {
		super();
		this.bookingService = bookingService;
	}

	
	@GetMapping( path = "/bookings")
	public List<Booking> getAllBookings()
	{
		return bookingService.getAllBookings();
		
	}
	
	@PostMapping(path ="/booking")
	public void addNewlBook( @RequestBody Booking booking )
	{
		bookingService.addNewBooking( booking);
	}
	
	@DeleteMapping( path = "{bookingId}")
	public void deleteBooking( @PathVariable( "bookingId" ) long bookingId )
	{
		bookingService.deleteBooking( bookingId );
		
	}
	
	@PutMapping( path = "{bookingId}")
	public void updateBooking( @PathVariable( "bookingId") long bookingId,
			@RequestParam( required = false ) LocalDate startDate,
			@RequestParam( required = false ) LocalDate endDate,
			@RequestParam( required = false ) int numberOfAdults,
			@RequestParam( required = false ) int numberOfChildern,
			@RequestParam( required = false ) int customerId)
	{
		bookingService.updateBooking( bookingId, startDate, endDate, numberOfAdults, numberOfChildern, customerId );
		
	}
	
}
