package com.example.springapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapi.exceptions.UserNotFoundException;
import com.example.springapi.model.User;
import com.example.springapi.service.UserService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
    @Autowired
	private UserService userService;
	
	
	
	@GetMapping("/home")
	public String hello() {
		System.out.println("hello");
		return "this is the home page";
	}
	
	
	@GetMapping("/users")
	public List<User> showUsers(){
		return userService.showUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable("id") int id) throws UserNotFoundException {
		User user = null;
		try {
			user = userService.getUser(id);			
		} catch (UserNotFoundException e) {
			System.out.println("User not found "+e.getMessage());
			
		}
		
//		User user = userService.getUser(id);		
		return user;
	}
	
	
	

}
