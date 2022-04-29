package com.hotel.project.hotelproject.cancelBooking;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelBookingService {
	
	private CancelBookingRepository cancelBookingRepository;
	
	@Autowired
	public CancelBookingService(CancelBookingRepository cancelBookingRepository) {
		super();
		this.cancelBookingRepository = cancelBookingRepository;
	}

	public List<CancelBooking> getAllCancelBookings()
	{
		
		return cancelBookingRepository.findAll();
	}
	
	public void addNewCancelBooking( CancelBooking cancelBooking )
	{
		Optional<CancelBooking> cancelBookingOptional = 
				cancelBookingRepository.findCancelBookingByBookingId( cancelBooking.getBookingId() );
		if(cancelBookingOptional.isPresent() )
		{
			throw new IllegalStateException( "This booking has already cancelled" );
		}
		cancelBookingRepository.save( cancelBooking );
	}
	
	public void deleteCancelBooking( Long cancelBookingId )
	{
		boolean exists = cancelBookingRepository.existsById( cancelBookingId ); 
		if( !exists )
		{
			throw new IllegalStateException( " cancellation booing by " + cancelBookingId + 
					" does not exists" );
		}
		cancelBookingRepository.deleteById( cancelBookingId );
	}
	
	@Transactional
	public void updateCancelBooking( long cancelBookingId,
			long bookingId,
			LocalDate cancellationDate, 
			String reasonForCancellation )
	{
		CancelBooking cancelBooking = cancelBookingRepository.findById( cancelBookingId )
				.orElseThrow( () -> new IllegalStateException( "cancelBooking with " + cancelBookingId + 
						"does not exists " ));
		if( bookingId != 0 && 
				!Objects.equals(cancelBooking.getBookingId(), bookingId ))
		{
			cancelBooking.setBookingId( bookingId );
		}
		
		if( cancellationDate != null && 
				!Objects.equals( cancelBooking.getCancellationDate(), cancellationDate) )
		{
			cancelBooking.setCancellationDate( cancellationDate );
		}
		
		if( reasonForCancellation != null && 
				reasonForCancellation.length() > 0 &&
				!Objects.equals(cancelBooking.getReasonForCancellation(), reasonForCancellation ))
		{
			cancelBooking.setReasonForCancellation( reasonForCancellation );
		}
		
	}
	

}
