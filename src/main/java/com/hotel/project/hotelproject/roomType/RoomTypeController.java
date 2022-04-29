package com.hotel.project.hotelproject.roomType;

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
//@RequestMapping( path = "/roomTypes")
@RequestMapping( path = "/roomTypes0")
@CrossOrigin(origins = "http://localhost:19006")
public class RoomTypeController {
	
	private RoomTypeService roomTypeService;
	
	
	@Autowired
	public RoomTypeController(RoomTypeService roomTypeService) {
		super();
		this.roomTypeService = roomTypeService;
	}

	//@GetMapping(path = "/roomTypes")
	public List<RoomType> getAllRoomTypes()
	{
		return roomTypeService.getAllRoomTypes();
	}
	
	@PostMapping
	public void addNewRoomType( @RequestBody RoomType roomType )
	{
		roomTypeService.addNewRoomType( roomType );
	}
	
	@DeleteMapping( path = "{roomTypeId}" )
	public void deleteRoomType( @PathVariable( "roomTypeId" ) long roomTypeId )
	{
		roomTypeService.deleteRoomType( roomTypeId );
		
	}
	
	@PutMapping( path = "{roomTypeId}" )
	public void updateRoomType( @PathVariable( "roomTypeId" ) long roomTypeId,
			@RequestParam( required = false ) String requirements,
			@RequestParam( required = false ) int capacity )
	{
		roomTypeService.updateRoomType( roomTypeId, requirements, capacity );
	}

}
