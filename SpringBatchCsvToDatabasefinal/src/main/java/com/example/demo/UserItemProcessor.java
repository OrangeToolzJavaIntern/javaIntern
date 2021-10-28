package com.example.demo;

import org.springframework.batch.item.ItemProcessor;

import com.example.demo.Bean.User;

public class UserItemProcessor implements ItemProcessor<User, User>{
	
	 

	@Override
	 public User process(User user) throws Exception {
		
	String email = user.getEmail();
	if (email.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$")) {
		user.setEmail(email);
	}else {
		
		String setString = "Email is not Valid Format";
		user.setEmail(setString);
	}


	return user;
  
	}
	
}


