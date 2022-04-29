package com.hotel.project.hotelproject.staff;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
	
	private StaffRepository staffRepository;
	
	@Autowired
	public StaffService(StaffRepository staffRepository) {
		super();
		this.staffRepository = staffRepository;
	}

	public List<Staff> getAllStaffs()
	{
		return staffRepository.findAll();
	}

	public void addNewStaff(Staff staff) {
		Optional<Staff> staffOptional = staffRepository.findStaffByEmail( staff.getEmail() );
		if( staffOptional.isPresent() )
		{
			throw new IllegalStateException( "the email address was taken" );
		}
		
	    staffRepository.save( staff );
		
	}

	public void deleteStaff(long staffId) {
		boolean exists = staffRepository.existsById( staffId );
		
		if( !exists )
		{
			throw new IllegalStateException( " staff with id " + staffId + " does not exists");
		}
		
		staffRepository.deleteById( staffId );
		
	}

	@Transactional
	public void updateStaff( long staffId, 
			String firstName, 
			String lastName,
			String email, 
			String password ) {
		Staff staff = staffRepository.findById( staffId )
				.orElseThrow( () -> new IllegalStateException(
						"staff with id " + staffId + "does not exists" ));
		if( firstName != null &&
				firstName.length() > 0 &&
				!Objects.equals( staff.getFirstName(), firstName ))
		{
			staff.setFirstName( firstName );
		}
		
		if( lastName != null &&
				lastName.length() > 0 &&
				!Objects.equals( staff.getLastName(), lastName ))
		{
			staff.setLastName( lastName );
		}
		
		if( email != null &&
				email.length() > 0 && 
				!Objects.equals( staff.getEmail(), email )) {
			Optional<Staff> staffOptional = 
					staffRepository.findStaffByEmail( email );
			if( staffOptional.isPresent() )
			{
				throw new IllegalStateException( "the email address was taken" );
				
			}
			staff.setEmail( email );
			
		}
		
		
	}

}
