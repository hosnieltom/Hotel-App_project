package com.hotel.project.hotelproject.hosted;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostedService {
	
	private HostedRepository hostedRepository;
	
	@Autowired
	public HostedService(HostedRepository hostedRepository) {
		super();
		this.hostedRepository = hostedRepository;
	}

	public List<Hosted> getAllHosts()
	{
		return hostedRepository.findAll();
	}
	

}
