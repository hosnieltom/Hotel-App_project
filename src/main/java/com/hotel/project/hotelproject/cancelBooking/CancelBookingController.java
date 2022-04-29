package com.hotel.project.hotelproject.cancelBooking;

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
@RequestMapping( path = "/cancelBookings")
public class CancelBookingController {
	
	private CancelBookingService cancelBookingService;
	
	@Autowired
	public CancelBookingController( CancelBookingService cancelBookingService ) {
		super();
		this.cancelBookingService = cancelBookingService;
	}

	@GetMapping
	public List<CancelBooking> getAllCancelBookings()
	{
		return cancelBookingService.getAllCancelBookings();
	}
	
	@PostMapping
	public void addNewCancelBooking( @RequestBody CancelBooking cancelBooking )
	{
		cancelBookingService.addNewCancelBooking( cancelBooking );
	}
	
	@DeleteMapping( path = "{cancelBookingId}" )
	public void deleteCancelBooking( @PathVariable( "cancelBookingId" ) long cancelBookingId )
	{
		cancelBookingService.deleteCancelBooking( cancelBookingId );
		
	}
	
	// I need to fix how to update the date in postman
	@PutMapping( path = "{cancelBookingId}" )
	public void updateCancelBooking( @PathVariable( "cancelBookingId" ) long cancelBookingId,
			@RequestParam( required = false ) long bookingId,
			@RequestParam( required = false ) LocalDate cancellationDate,
			@RequestParam( required = false ) String reasonForCancellation )
	{
		cancelBookingService.updateCancelBooking( cancelBookingId, bookingId,
				cancellationDate, reasonForCancellation );
	}

}
