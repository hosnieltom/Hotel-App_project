package com.hotel.project.hotelproject.bookingRoom;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRoomRepository  extends JpaRepository<BookingRoom, Long> {
	Optional<BookingRoom> findBookingRoomById( Long id );

}
