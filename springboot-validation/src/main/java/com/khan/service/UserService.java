package com.khan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khan.model.User;
import com.khan.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//public User createUser(User user) {
	//	return userRepository.save(user);
	//}

	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	
	

}
