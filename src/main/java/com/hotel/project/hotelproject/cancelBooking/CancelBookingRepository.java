package com.hotel.project.hotelproject.cancelBooking;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CancelBookingRepository extends JpaRepository<CancelBooking, Long>{
	
	Optional<CancelBooking> findCancelBookingByBookingId( long bookingId );

}
