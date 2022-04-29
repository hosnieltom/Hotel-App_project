package com.hotel.project.hotelproject.hosted;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( path = "/hosts")
public class HostedController {
	
	private HostedService hostedService;
	
	@Autowired
	public HostedController(HostedService hostedService) {
		super();
		this.hostedService = hostedService;
	}



	@GetMapping
	public List<Hosted> getAllHosts()
	{
		return hostedService.getAllHosts();
	}

}
