package com.sample.obs.OnlineBookStore.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.obs.OnlineBookStore.entity.Customer;
import com.sample.obs.OnlineBookStore.exceptions.ResourceNotFoundException;
import com.sample.obs.OnlineBookStore.service.CustomerService;

/**
 * Rest API for customer.
 * @author Pallavi Prasad
 *
 */
@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@GetMapping("/customers/email/{email}")
	public ResponseEntity<Customer> retrieveCustomerByEmail(@PathVariable("email") String email) throws ResourceNotFoundException {
		Customer c = service.retrieveByEmail(email);
		
		if (c == null) {
			throw new ResourceNotFoundException("Customer with email: " + email + " not found");
		}
		
		return ResponseEntity.ok().body(c);
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> retrieveCustomerById(@PathVariable("id") long id) throws ResourceNotFoundException {
		Customer c = service.retrieveCustomerById(id);
		
		if (c == null) {
			throw new ResourceNotFoundException("Customer with id: " + id + " not found");
		}
		
		return ResponseEntity.ok().body(c);
	}

	@PostMapping("/customers")
	public ResponseEntity<Customer> saveNewCustomer(@RequestBody Customer customer) {
		Customer c = service.saveCustomer(customer);
		
		return ResponseEntity.ok().body(c);
	}
	
	@PutMapping("/customers/password/{password}/{id}")
	@Transactional
	public ResponseEntity<String> updatePassword(@PathVariable("password") String password, @PathVariable("id") long id) {
		String str = service.updatePassword(password, id);
		return ResponseEntity.ok().body(str);
	}
	
	@PutMapping("/customers/wallet/{wallet}/{id}")
	@Transactional
	public ResponseEntity<String> updateWallet(@PathVariable("wallet") double wallet, @PathVariable("id") long id) {
		String str = service.updateWallet(wallet, id);
		return ResponseEntity.ok().body(str);
	}
	
	@PutMapping("/customers/coupon/{coupon}/{id}")
	@Transactional
	public ResponseEntity<String> updateCoupon(@PathVariable("coupon") String coupon, @PathVariable("id") long id) {
		String str = service.updateCoupon(coupon, id);
		return ResponseEntity.ok().body(str);
	}
}
