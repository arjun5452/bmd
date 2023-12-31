package com.bmd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bmd.model.User;
import com.bmd.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = repository.findByMobileNo(username).orElseThrow(()-> new RuntimeException("User not Found !!!"));
		// load user From database
		User user = repository.findByPhoneNumber(username);
		return user;
	}

}
