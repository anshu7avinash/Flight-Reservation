package com.avinash.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Override
	public boolean login(String username, String password) {
		
		//step 1 : retrieve the details from the service
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		
		//step 2: create the username-password token and pass the three args username,password, user roles for verification
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password,
				userDetails.getAuthorities());

		//step 3: authenticate the details using authenticationManager(API used for verifying) of spring 
		authenticationManager.authenticate(token);
		
		//step 4: store the result and forward
		boolean result = token.isAuthenticated();
		
		//step 5: if user is authenticated then store the role
		if(result){
			//spring will store the information for user and will not again ask the password
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		return result;
	}

}
