package com.example.springapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapi.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	

	private UserService userService;
	
	public UserController() {
		
	}
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/home")
	public String hello() {
		return "Welcome home";
	}
	
	
	
	

}
