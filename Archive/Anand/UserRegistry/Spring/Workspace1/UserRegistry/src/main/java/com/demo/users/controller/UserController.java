package com.demo.users.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.users.exceptions.UserNotFoundException;
import com.demo.users.model.User;
import com.demo.users.service.UserService;



@CrossOrigin(origins = "${cross.url}")
@RestController
@PropertySource("classpath:application.properties")
public class UserController {
	
	 @Value("${userId}")
	 private String id;
	

    @Autowired
	private UserService userService;
	
	
	@GetMapping("/home")
	public String hello() {
		System.out.println("hello");
		return "this is the home page";
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK) ;
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id){
		User user = userService.getUser(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
	    try {
	        userService.deleteUser(id);
	        return ResponseEntity.ok().body("deleted successfully");
	    } catch (UserNotFoundException e) {
	        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	    }
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User updatedUser){
	    try {
	        User currentUser = userService.updateUser(id, updatedUser);
	        return ResponseEntity.ok().body(currentUser);
	    } catch (UserNotFoundException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	
	
	
	
	
	
//	@GetMapping("/users/{id}")
//	public ResponseEntity<User> getUser(@PathVariable("id") int id) throws UserNotFoundException{
//		User user = null;
//		try {
//			user = userService.getUser(id);			
//		} catch (UserNotFoundException e) {
//			System.out.println("User not found : "+e.getMessage());
//			return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
//			
//		}
//		return new ResponseEntity<>(user,HttpStatus.OK);
//	}
	
	

	
//	@GetMapping("/users/{id}")
//	public User getUser(@PathVariable("id") int id) throws UserNotFoundException {
//		User user = null;
//		try {
//			user = userService.getUser(id);			
//		} catch (UserNotFoundException e) {
//			System.out.println("User not found : "+e.getMessage());
//			
//		}
//		
////		User user = userService.getUser(id);		
//		return user;
//	}
	
	
	
	
	
	
	
	
	

}
