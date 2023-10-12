package com.content.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.content.exception.ResourceNotFoundException;
import com.content.model.User;
import com.content.repostories.UserRepo;
@Service
public class CustomeUserDetailService implements UserDetailsService{
@Autowired
	private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = null;
		try {
			user = userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("user", "email : "+username ,0));

		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}


}
