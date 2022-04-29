package com.hotel.project.hotelproject.staff;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StaffRepository extends JpaRepository< Staff, Long>{
	Optional<Staff> findStaffByEmail( String email );

}
