package com.hotel.project.hotelproject.staff;

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
@CrossOrigin 
@RequestMapping( path = "/staffs")
public class StaffController {
	
	private StaffService staffService;
	
	@Autowired
	public StaffController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}

	@GetMapping
	public List<Staff> getAllStaffs()
	{
		return staffService.getAllStaffs();
		
	}
	@PostMapping
	public void addNewStaff( @RequestBody Staff staff )
	{
		staffService.addNewStaff( staff );
		
	}
	
	@DeleteMapping( path = "{staffId}" )
	public void deleteStaff( @PathVariable( "staffId" ) long staffId )
	{
		staffService.deleteStaff( staffId );
	}
	
	@PutMapping( path = "{staffId}" )
	public void  updateStaff( @PathVariable( "staffId" ) long staffId,
			@RequestParam( required = false ) String firstName,
			@RequestParam( required = false ) String lastName,
			@RequestParam( required = false ) String email,
			@RequestParam( required = false ) String password )
	{
		staffService.updateStaff( staffId, firstName, lastName, email, password );
	}

}
