package com.hotel.project.hotelproject.security.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hotel.project.hotelproject.registration.RegistrationRequest;
import com.hotel.project.hotelproject.registration.token.ConfirmationToken;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTTokenHelper jwtTokenHelper;
	private ConfirmationToken confirmationToken;
	RegistrationRequest req;
	
	public JWTAuthenticationFilter(UserDetailsService userDetailsService ) {
		this.userDetailsService=userDetailsService;
		
		
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		//String authToken=jwtTokenHelper.getToken(request);
		final String authorizationHeader = request.getHeader("Authorization");
		
		String username = null;
		String jwt = null;
		
		if( authorizationHeader != null &&  authorizationHeader.startsWith("Bearer ") ) {
			jwt =  authorizationHeader.substring(7);
			username = jwtTokenHelper.getUsernameFromToken(jwt);
		}
		
		if( username != null && SecurityContextHolder.getContext().getAuthentication() == null ) {
			
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			
			if(jwtTokenHelper.validateToken(jwt, userDetails) ) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
			}
		}
		
		filterChain.doFilter(request, response);
		
		
		/*
		String authToken=confirmationToken.getToken();
		
		if(null!=authToken) {
			
			String userName= req.getEmail();
			
			if(null!=userName) {
				
				UserDetails userDetails=userDetailsService.loadUserByUsername(userName);
					
					UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetails(request));
					
					SecurityContextHolder.getContext().setAuthentication(authentication);
				
				
			}
			
		}
		
		filterChain.doFilter(request, response);
		
		
		*/
	}

}
