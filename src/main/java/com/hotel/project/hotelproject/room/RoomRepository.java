package com.hotel.project.hotelproject.room;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	
	Optional<Room> findRoomByRoomNumber( String roomNumber );

}
