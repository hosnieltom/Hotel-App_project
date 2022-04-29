package com.hotel.project.hotelproject.bookingRoom;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingRoomService {
	
	private BookingRoomRepository bookingRoomRepository;
	
    @Autowired
	public BookingRoomService(BookingRoomRepository bookingRoomRepository) {
		super();
		this.bookingRoomRepository = bookingRoomRepository;
	}


	public List<BookingRoom> getAllBookingRooms()
	{
		return bookingRoomRepository.findAll();
	}
	
	public void addNewBookingRoom( BookingRoom bookingRoom )
	{
		Optional<BookingRoom> bookingRoomOptional = 
				bookingRoomRepository.findById( bookingRoom.getId() );
		
		if( bookingRoomOptional.isPresent() )
		{
			throw new IllegalStateException( "booking room has taken" );
		}
		
		bookingRoomRepository.save( bookingRoom );
	}
	
	public void deleteBookingRoom( long bookingRoomId )
	{
		boolean exists = bookingRoomRepository.existsById( bookingRoomId );
		if( !exists )
		{
				throw new IllegalStateException( "bookingRoom with id " + bookingRoomId + 
						" does not exists" );
		}
		bookingRoomRepository.deleteById( bookingRoomId );
	}
	
	@Transactional
	public void updateBookingRoom( long bookingRoomId,
			int numberOfRooms,
			String status,
			int bookingId,
			int roomTypeId )
	{
		BookingRoom bookingRoom = bookingRoomRepository.findById( bookingRoomId )
				.orElseThrow( () -> new IllegalStateException(
						"bookingRoom with id " + bookingRoomId + " does not exists") );
	/*
		if( bookingRoomId != 0 &&
				bookingRoomId > 0 &&
				!Objects.equals( bookingRoom.getId(), bookingRoomId ) )
		{
			Optional<BookingRoom> bookingRoomOptional = bookingRoomRepository.findById( bookingRoomId );
			if(bookingRoomOptional.isPresent())
			{
				throw new IllegalStateException( "bookingRoom has been taken" );
			}
			
			bookingRoom.setId( bookingRoomId );
		}
		*/
		if( numberOfRooms != 0 &&
				numberOfRooms > 0 &&
				!Objects.equals( bookingRoom.getNumberOfRoom(), numberOfRooms ) )
		{
			bookingRoom.setNumberOfRoom( numberOfRooms );
		}
		
		if( status != null &&
				!Objects.equals( bookingRoom.getStatus(), status ) )
		{
			bookingRoom.setStatus( status );
		}
		
		if( bookingId != 0 &&
				numberOfRooms > 0 &&
				!Objects.equals( bookingRoom.getBookingId(), bookingId ) )
		{
			bookingRoom.setBookingId( bookingId );
		}
		
		if( roomTypeId != 0 &&
				numberOfRooms > 0 &&
				!Objects.equals( bookingRoom.getRoomTypeId(), roomTypeId ) )
		{
			bookingRoom.setRoomTypeId( roomTypeId );
		}
		
	}
	


}
