package com.avinash.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.avinash.flightreservation.entities.User;
import com.avinash.flightreservation.repos.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(userName);
		if(userName==null){
			throw new UsernameNotFoundException("User Name not found for email "+userName);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),user.getRoles());
	}

}
