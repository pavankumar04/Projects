package com.sample.obs.OnlineBookStore.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.obs.OnlineBookStore.entity.Employee;
import com.sample.obs.OnlineBookStore.service.EmployeeService;

/**
 * Rest API for Employee
 * @author Pallavi Prasad
 *
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employees/email/{email}")
	public ResponseEntity<Employee> retrieveEmployeeByEmail(@PathVariable("email") String email){
		Employee e = service.retrieveEmployeeByEmail(email);
		return ResponseEntity.ok().body(e);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> retrieveEmployeeById(@PathVariable("id") long id){
		Employee e = service.retrieveEmployeeById(id);
		return ResponseEntity.ok().body(e);
	}
	
	@PutMapping("/employees/password/{password}/{id}")
	@Transactional
	public ResponseEntity<String> updatePassword(@PathVariable("password") String password, @PathVariable("id") long id) {
		String str = service.updatePassword(password, id);
		return ResponseEntity.ok().body(str);
	}
	
	@PutMapping("/employees/phone/{phone}/{id}")
	@Transactional
	public ResponseEntity<String> updatePhone(@PathVariable("phone") String phone, @PathVariable("id") long id) {
		String str = service.updatePhone(phone, id);
		return ResponseEntity.ok().body(str);
	}
}
