package com.hotel.project.hotelproject.occupiedRoom;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupiedRoomRepository  extends JpaRepository<OccupiedRoom, Long>{
	
	Optional<OccupiedRoom> findOccupiedRoomById( long id );

}
