package com.hotel.project.hotelproject.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepository extends JpaRepository<Role,Long>{
//Optional<Role> findByName( String name );
	
    @Query("SELECT r FROM Role r WHERE r.name = ?1")
    public Role findByName( String name );

}
