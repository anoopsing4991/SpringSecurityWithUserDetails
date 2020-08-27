package com.security.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.MyUserDetails;
import com.security.UserRepository;
import com.security.entity.User;
@Service
public class MyUserDetailsService implements UserDetailsService{
@Autowired
UserRepository userRepository;
	/*
	 * @Override public UserDetails loadUserByUsername(String s) throws
	 * UsernameNotFoundException { // TODO Auto-generated method stub return new
	 * MyUserDetails(s); }
	 */

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user= userRepository.findByUserName(userName);
		user.orElseThrow(()->new UsernameNotFoundException("user not found "+userName));
		return user.map(MyUserDetails::new).get();
	}
}
