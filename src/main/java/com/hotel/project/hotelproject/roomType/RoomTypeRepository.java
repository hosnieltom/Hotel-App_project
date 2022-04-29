package com.hotel.project.hotelproject.roomType;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository  extends JpaRepository<RoomType, Long> {
	Optional<RoomType> findRoomTypeById( Long id );

}
