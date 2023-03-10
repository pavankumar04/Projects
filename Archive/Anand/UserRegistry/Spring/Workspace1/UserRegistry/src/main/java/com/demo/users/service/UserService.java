package com.demo.users.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.demo.users.exceptions.UserNotFoundException;
import com.demo.users.model.User;

@Service
public class UserService {
	
	private Map<Integer, User> userList;

	
	public UserService() {
		userList = new HashMap<>();
        User user1 = new User(1, "lokesh", 27, "lokesh2@gmail.com");
        User user2 = new User(2, "rajesh", 32, "rajesh3@gmail.com");
        User user3 = new User(3, "rani", 26, "rani3@gmail.com");
        User user4 = new User(4, "kiran", 28, "kiran14@gmail.com");
        User user5 = new User(5, "hari", 31, "hari5@gmail.com");

        userList.put(user1.getId(), user1);
        userList.put(user2.getId(), user2);
        userList.put(user3.getId(), user3);
        userList.put(user4.getId(), user4);
        userList.put(user5.getId(), user5);
	}
	
	public int getMaxUserId() {
		 return userList.keySet().stream().mapToInt(Integer::intValue).max().orElse(0);
	}
	
	public List<User> getUsers(){
		return new ArrayList<>(userList.values());
	}
	
	
	public User getUser(int id){
		return userList.get(id);
	}
	

	public User addUser(User user) {
		int newId = this.getMaxUserId() + 1;
		user.setId(newId);
		userList.put(newId, user);
		return user;
	}
	
	public User updateUser(int id, User updatedUser) throws UserNotFoundException {
		User currentUser = userList.get(id);
		if (currentUser == null) {
		throw new UserNotFoundException("User with id " + id + " not found");
		}
		currentUser.setName(updatedUser.getName());
		currentUser.setAge(updatedUser.getAge());
		currentUser.setEmail(updatedUser.getEmail());
		userList.put(id, currentUser);
		return currentUser;
	}
	
	public void deleteUser(int id) throws UserNotFoundException {
		User user = userList.get(id);
		if (user == null) {
		throw new UserNotFoundException("User with id " + id + " not found");
		}
		userList.remove(id);
	}
	
	
//	public User getUser(int id)throws UserNotFoundException{
//	User user = userList.get(id);
//	System.out.println(user);
//	if (user == null) {
//        throw new UserNotFoundException("User with id " + id + " not found");
//    }
//    return user;
//	
//	
//}
	
	
	
	
	

}
