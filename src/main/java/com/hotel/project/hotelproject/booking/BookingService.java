package com.hotel.project.hotelproject.booking;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
	
	private BookingRepository bookingRepository;
	
	
	@Autowired
	public BookingService(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}


	public List<Booking> getAllBookings() {
		
		return bookingRepository.findAll();
		
	}


	public void addNewBooking(Booking booking) {
		Optional<Booking> bookingOptional = 
				bookingRepository.findById( booking.getId() );
		
		if( bookingOptional.isPresent() )
		{
			throw new IllegalStateException( "booking has been taken" );
		}
		
		bookingRepository.save( booking );
		
	}

   // I need to double check between bookingId and bookingNumber to see which one is the correct to use
	public void deleteBooking(long bookingId) {
		
		boolean exists = bookingRepository.existsById( bookingId );
		if( !exists )
		{
			throw new IllegalStateException( "booking with id " + bookingId + "does not exists" );
		}
		
		bookingRepository.deleteById( bookingId );
	}
	
	
	@Transactional
	public void updateBooking( long bookingId,
			//String bookingNumber, 
			//String roomNumber, 
			LocalDate startDate,
			LocalDate endDate ,
			int numberOfAdults,
	        int numberOfChildern,
	        int customerId) {
		
		Booking booking = bookingRepository.findById( bookingId )
				.orElseThrow( () -> new IllegalStateException(
						"booking with id \" + bookingId + \"does not exists") );
	
		if( bookingId != 0 &&
				bookingId > 0 &&
				!Objects.equals( booking.getId(), bookingId ) )
		{
			Optional<Booking> bookingOptional = bookingRepository.findById( bookingId );
			if(bookingOptional.isPresent())
			{
				throw new IllegalStateException( "booking has been taken" );
			}
			
			booking.setId( bookingId );
		}
		
		if( startDate != null &&
				!Objects.equals( booking.getStartDate(), startDate ) )
		{
			booking.setStartDate( startDate );
		}
		
		if( endDate != null && 
				!Objects.equals(booking.getEndDate(), endDate ) )
		{
			booking.setEndDate( endDate );
		}
		
		if( numberOfAdults != 0 &&
				numberOfAdults > 0 &&
				!Objects.equals( booking.getNumberOfAdults(), numberOfAdults ) )
		{
			booking.setNumberOfAdults( numberOfAdults );
		}
		if( numberOfChildern != 0 &&
				numberOfAdults > 0 &&
				!Objects.equals( booking.getNumberOfChildern(), numberOfChildern ) )
		{
			booking.setNumberOfChildern( numberOfChildern );
		}
		/*
		if( customerId != 0 &&
				customerId > 0 &&
				!Objects.equals( booking.getCustomerId(), customerId ) )
		{
			booking.setCustomerId( customerId );
		}
		*/
		
	}

}
