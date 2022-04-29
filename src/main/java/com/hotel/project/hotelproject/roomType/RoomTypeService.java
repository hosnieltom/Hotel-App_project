package com.hotel.project.hotelproject.roomType;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomTypeService {
	
	private RoomTypeRepository roomTypeRepository;
	
	
	@Autowired
	public RoomTypeService(RoomTypeRepository roomTypeRepository) {
		super();
		this.roomTypeRepository = roomTypeRepository;
	}


	public List<RoomType> getAllRoomTypes()
	{
		return roomTypeRepository.findAll();
	}
	
	public void addNewRoomType( RoomType roomType )
	{
		Optional<RoomType> roomTypeOptional = roomTypeRepository.findRoomTypeById( roomType.getId() );
		if( roomTypeOptional.isPresent() )
		{
			throw new IllegalStateException( "the roomTyoe number was taken" );
		}
		
		roomTypeRepository.save( roomType );
	}
	
	public void deleteRoomType( long roomTypeId )
	{
		boolean exists = roomTypeRepository.existsById( roomTypeId );
		if( !exists )
		{
			throw new IllegalStateException( "roomType with id " + roomTypeId + "does not exists" );
		}
		
		roomTypeRepository.deleteById( roomTypeId );
		
	}
	
	@Transactional
	public void updateRoomType( long roomTypeId, String requirements, int capacity )
	{
		RoomType roomType = roomTypeRepository.findById( roomTypeId )
				.orElseThrow( () -> new IllegalStateException( 
						"roomType with id " + roomTypeId + "does not exists" ));
		if( requirements != null && 
				requirements.length() > 0 && 
    			!Objects.equals( roomType.getRequirements(), requirements ) ) {
		
    		roomType.setRequirements( requirements ) ;
    	}
		
		if( capacity != 0 && 
    			capacity > 0 && 
    			!Objects.equals(roomType.getCapacity(), capacity )) {
		
    		roomType.setCapacity( capacity );
    	}
	}
		

}
