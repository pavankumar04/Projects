package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;


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
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody User us)
	{
		return userService.saveUser(us);
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") int id) throws UserNotFoundException {
		User user = null;
		try {
			user = userService.getUser(id);			
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		
//		User user = userService.getUser(id);		
		return user;
	}
	
	@PutMapping("/updateUserById/{id}")
	public User updateUserById(@PathVariable("id") int id, @RequestBody User us)
	{
		return userService.updateUserById(id,us);
	}
	
	@PutMapping("/updateUserByName/{name}")
	public User updateUserByName(@PathVariable("name") String name, @RequestBody User us)
	{
		return userService.updateUserByName(name, us);
	}
	
	
	
	
}
