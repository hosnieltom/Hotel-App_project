package com.hotel.project.hotelproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
//@ComponentScan( { "it.myapplication.controllers" } )
//@EnableCaching

public class HotelProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelProjectApplication.class, args);
	}

}
