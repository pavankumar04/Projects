package com.example.springapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springapi.exceptions.UserNotFoundException;
import com.example.springapi.model.User;

@Service
public class UserService {
	
	private List<User> userList;
	
	public UserService() {
		userList = new ArrayList<>();
		
		User user1 = new User(1,"lokesh",27,"lokesh2@gamil.com");
		User user2 = new User(2,"rajesh",32,"rajesh3@gamil.com");
		User user3 = new User(3,"rani",26,"rani3@gamil.com");
		User user4 = new User(4,"kiran",28,"kiran14@gamil.com");
		User user5 = new User(5,"hari",31,"hari5@gamil.com");
		
		userList.addAll(Arrays.asList(user1,user2,user3,user4,user5));
	}
	
	public List<User> showUsers(){
		return userList;
	}
	
	
	public User getUser(int id)throws UserNotFoundException{
		for(User user : userList) {
			if(id == user.getId()) {
				System.out.println(user.toString());
				return user;
			}
		}
		throw new UserNotFoundException("User with id " + id + " not found");
	}
	
	

}
