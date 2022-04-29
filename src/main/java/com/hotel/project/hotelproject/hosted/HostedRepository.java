package com.hotel.project.hotelproject.hosted;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostedRepository extends JpaRepository<Hosted, Long>{
	Optional<Hosted> findHostedById( long id );

}
