package com.hotel.project.hotelproject.occupiedRoom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OccupiedRoomService {
	
	private OccupiedRoomRepository occupiedRoomRepository;
	
	@Autowired
	public OccupiedRoomService(OccupiedRoomRepository occupiedRoomRepository) {
		super();
		this.occupiedRoomRepository = occupiedRoomRepository;
	}


	public List<OccupiedRoom> getAllOccupiedRooms()
	{
		
		return occupiedRoomRepository.findAll();
	}

}
