package com.hotel.project.hotelproject.occupiedRoom;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( path = "/occupiedRooms")
public class OccupiedRoomController {
	
	private OccupiedRoomService occupiedRoomService;
	
	@Autowired
	public OccupiedRoomController(OccupiedRoomService occupiedRoomService) {
		super();
		this.occupiedRoomService = occupiedRoomService;
	}


	@GetMapping
	public List<OccupiedRoom> getAllOccupiedRooms()
	{
		return occupiedRoomService.getAllOccupiedRooms();
	}

}
