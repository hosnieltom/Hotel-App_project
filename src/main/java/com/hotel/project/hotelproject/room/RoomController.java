package com.hotel.project.hotelproject.room;

import java.io.IOException;
import java.io.*;
import java.nio.file.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
//@CrossOrigin(origins = "*")
@RequestMapping( path = "/api/1.0")
//@CrossOrigin(origins = "http://localhost:19006")
public class RoomController {
	
	private RoomService roomService;
	
	
	@Autowired
	public RoomController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}
	
	/*
	@GetMapping
	public String getAllRooms( Model model )
	{
		model.addAttribute("rooms", roomService.getAllRooms());
		return  "room";
		
	}
	*/
	//@CrossOrigin(origins = "http://localhost:19006")
	@GetMapping( path = "/rooms")
	public List<Room> getAllRooms()
	{
		return  roomService.getAllRooms();
		
	}
	
	@GetMapping( path = "/room/{roomId}" )
	public Optional<Room> getRoom( @PathVariable ( "roomId" ) long roomId)
	{
		return roomService.getRoom( roomId );
	}
	
	
	@PostMapping("/test")
	public ResponseEntity<?> addTestRoom( @RequestParam("image")
   		 MultipartFile image ,@RequestParam("room") String room  )
           
	{
		
		if(room != null )
		{ System.out.println("room json" + room);}
		if( image != null )
		{System.out.println("image" + image);}
		
		return new ResponseEntity<>(room,HttpStatus.OK);
		
	}


	@PostMapping(path ="/room")
	public void addNewRoom( @RequestBody Room room )
           
	{
		
		roomService.addNewRoom( room );
	}
	
	/*
	
	@PostMapping(
			path = "/image",
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
			produces = MediaType.MULTIPART_FORM_DATA_VALUE)
	
    public void addNewRoom( Room room ,
    		@RequestParam("image") MultipartFile image ) throws IOException  {
		roomService.addNewRoom( room );
		
		//return "/room";		//roomRepository.save( room );
		//return new RedirectView("/rooms", true);

       // User savedUser = repo.save(user);
        //Room savedRoom = roomRepository.save( room );
 
}

	
	@PostMapping
	public void addNewRoom( @RequestBody Room room )
           
	{
		
		roomService.addNewRoom( room );
	}
	
	
	*/
	
	@PostMapping("image"
			//path = "/image",
			//consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
			//produces = MediaType.MULTIPART_FORM_DATA_VALUE
			
			)
    public  void  addNewRoom(  
    		RedirectAttributes ra,
    		@RequestParam("data") Room room,
    		@RequestParam("image") MultipartFile image ) throws IOException  {
		
		String fileName = StringUtils.cleanPath( image.getOriginalFilename() );
        room.setImage( fileName );
        Room savedRoom = roomService.addNewRoom( room );
        String uploadDir = "room-images/" + savedRoom.getId();
        FileUploadUtil.saveFile( uploadDir, fileName, image );
        
        Path uploadPath = Paths.get(uploadDir);
        
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
         
        try (InputStream inputStream = image.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + fileName, ioe);
        }  
        
        
		ra.addFlashAttribute("message",	 "upload successfully");
		roomService.addNewRoom( room );
		
		//return "/room";		//roomRepository.save( room );
		//return new RedirectView("/rooms", true);

       // User savedUser = repo.save(user);
        //Room savedRoom = roomRepository.save( room );
 
}


	
	@DeleteMapping( path = "/delete/room/{roomId}" )
	public void deleteRoom(  @PathVariable ( "roomId" ) long roomId)
	{
		// I need to add more validation to check if the id is not null
		roomService.deleteRoom( roomId );
	}
	/*
	@PutMapping(path = "/room/{roomId}")
	public Room updateRoom2( @RequestBody Room room, @PathVariable("roomId") long roomId) {
		this.roomService.updateRoom2( room, roomId); 
		return room;
		
	}
	*/
	
	@PutMapping( path = "/update/{roomId}" )
	public void updateRoom( @PathVariable ( "roomId" ) long roomId,
			@RequestParam( required = false ) String roomNumber,
			//@RequestParam( required = false ) int roomTypeId,
			//@RequestParam( required = false ) String status,
			@RequestParam( required = false ) double cost,
			@RequestParam( required = false ) String requirements,
			@RequestParam( required = false ) int capcity,
			@RequestParam( required = false ) String image)
	{
		roomService.updateRoom( roomId, roomNumber,cost, requirements, capcity, image );

	}
	
}
