package com.hotel.project.hotelproject.room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.io.*;
import java.nio.file.*;


import javax.transaction.Transactional;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class RoomService {
	//List<Room> list = new ArrayList();
	private RoomRepository roomRepository;
	

	@Autowired
	public RoomService( RoomRepository roomRepository ) {
		super();
		this.roomRepository = roomRepository;
	}
	
	public List<Room> getAllRooms()
	{
	   
		return roomRepository.findAll();
	}
	
	public Room addNewRoom( Room room) {

		Optional<Room> roomOptional = roomRepository.findRoomByRoomNumber( room.getRoomNumber());
			
		if( roomOptional.isPresent() )
		{
			throw new IllegalStateException( "room number was taken" );
		}
		
		 roomRepository.save( room );
		 return room;
		

       // User savedUser = repo.save(user);
        //Room savedRoom = roomRepository.save( room );
 
}
	
   

	/*
	 public void addImageRoom( UUID roomId, MultipartFile file) {

 
}
	
	public void addNewRoom( Room room, MultipartFile file ) throws IOException  {
		
		String fileName = StringUtils.cleanPath( file.getOriginalFilename() );
        room.setImage( fileName );
        Room savedRoom = roomRepository.save( room );
        String uploadDir = "room-images/" + savedRoom.getId();
        FileUploadUtil.saveFile( uploadDir, fileName, file );
         
		
		Optional<Room> roomOptional = roomRepository.findRoomByRoomNumber( room.getRoomNumber());
			
		if( roomOptional.isPresent() )
		{
			throw new IllegalStateException( "room number was taken" );
		}
		
		//roomRepository.save( room );
		//return new RedirectView("/rooms", true);

       // User savedUser = repo.save(user);
        //Room savedRoom = roomRepository.save( room );
 
}
	
	 * This is last function
	public void addNewRoom(Room room, MultipartFile file ) throws IOException  {
			
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	        room.setImage( Base64.getEncoder().encodeToString( file.getBytes()));
	         
			
			Optional<Room> roomOptional = roomRepository.findRoomByRoomNumber( room.getRoomNumber());
				
			if( roomOptional.isPresent() )
			{
				throw new IllegalStateException( "room number was taken" );
			}
			
			roomRepository.save( room );
	
	       // User savedUser = repo.save(user);
	        //Room savedRoom = roomRepository.save( room );
	 
	}
		
	
	public static void saveFile(String uploadDir, String fileName,
            MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
         
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
         
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + fileName, ioe);
        }      
    }

	public void addNewRoom(Room room, MultipartFile multipartFile ) throws IOException  {
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        room.setImage(fileName);
         
		
		Optional<Room> roomOptional = roomRepository.findRoomByRoomNumber( room.getRoomNumber());
			
		if( roomOptional.isPresent() )
		{
			throw new IllegalStateException( "room number was taken" );
		}
		
		//roomRepository.save( room );

       // User savedUser = repo.save(user);
        Room savedRoom = roomRepository.save( room );
 
        String uploadDir = "room-photos/" + savedRoom.getId();
 
        //FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        saveFile(uploadDir, fileName, multipartFile);
}
*/

	public void deleteRoom(long roomId) {
		boolean exists = roomRepository.existsById( roomId );
		if( !exists )
		{
			throw new IllegalStateException(
					"room with id" + roomId + "does not exists" );
		}
		
		roomRepository.deleteById( roomId );
	}
	
	public Optional<Room> getRoom( long roomId ) {
		boolean exists = roomRepository.existsById( roomId );
		
		if( !exists )
		{
			throw new IllegalStateException(
					"room with id" + roomId + "does not exists" );
		}
		return  roomRepository.findById( roomId );
		
		
	}
	/*
	public Room updateRoom2( Room room, long roomId) {
		List
		
	}
	*/
	
    @Transactional
	public void updateRoom(long roomId,
			String roomNumber,
			//int roomTypeId, 
			//String status,
			double cost,
			String requirements,
			int capacity,
			String image) {
		Room room  = roomRepository.findById( roomId )
				.orElseThrow( () -> new IllegalStateException( 
						"room with id " + roomId + "does not exists" ));
		if( roomNumber != null && 
    			roomNumber.length() > 0 && 
    			!Objects.equals(room.getRoomNumber(), roomNumber )) {
			/*
			Optional<Room> roomOptional =
    				roomRepository.findRoomByRoomNumber( roomNumber );
    		if( roomOptional.isPresent() )
    		{
    			throw new IllegalStateException( "room number was taken" );
    		}
    		*/
		
    		room.setRoomNumber( roomNumber );
    	}
		/*
		
		if( roomTypeId != 0 && 
				roomTypeId > 0 && 
    			!Objects.equals( room.getRoomTypeId(), roomTypeId ) ) {
		
    		room.setRoomTypeId( roomTypeId ) ;
    	}
		
		if( status != null && 
    			status.length() > 0 && 
    			!Objects.equals(room.getStatus(), status )) {
		
    		room.setStatus( status );
    	}
    	*/
		
		if( cost != 0 &&  
    			!Objects.equals(room.getCost(), cost )) {
		
    		room.setCost( cost );
    	}    
		if( requirements != null && 
				requirements.length() > 0 && 
    			!Objects.equals( room.getRequirements(), requirements ) ) {
		
    		room.setRequirements( requirements ) ;
    	}
		
		if( capacity != 0 && 
    			capacity > 0 && 
    			!Objects.equals(room.getCapacity(), capacity )) {
		
    		room.setCapacity( capacity );
    	}
		if( image != null && 
    			image.length() > 0 && 
    			!Objects.equals(room.getImage(), image )) {
		
    		room.setImage(image);
    	}
    	
	}
	
}
