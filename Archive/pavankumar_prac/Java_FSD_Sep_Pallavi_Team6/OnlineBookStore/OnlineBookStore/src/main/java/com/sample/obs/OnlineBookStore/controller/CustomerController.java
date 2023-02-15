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
	
	/**
	 * to get customer details based on email
	 * @param email for the email
	 * @return ResponseEntity<Customer> object
	 */
	@GetMapping("/customers/email/{email}")
	public ResponseEntity<Customer> retrieveCustomerByEmail(@PathVariable("email") String email){
		Customer c = null;
		try {
			c = service.retrieveByEmail(email);
		} catch (ResourceNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return ResponseEntity.ok().body(c);
	}
	
	/**
	 * to get customer details based on id.
	 * @param id for the customer id
	 * @return ResponseEntity<Customer> object
	 */
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> retrieveCustomerById(@PathVariable("id") long id){
		Customer c = null;
		try {
			c = service.retrieveCustomerById(id);
		} catch (ResourceNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return ResponseEntity.ok().body(c);
	}

	/**
	 * to upload new customer details
	 * @param customer for the Customer object
	 * @return ResponseEntity<Customer> object
	 */
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveNewCustomer(@RequestBody Customer customer) {
		Customer c = service.saveCustomer(customer);
		
		return ResponseEntity.ok().body(c);
	}
	
	/**
	 * to update the customer password
	 * @param password for the password
	 * @param id for the customer id
	 * @return ResponseEntity<String>
	 */
	@PutMapping("/customers/password/{password}/{id}")
	@Transactional
	public ResponseEntity<String> updatePassword(@PathVariable("password") String password, @PathVariable("id") long id) {
		String str = service.updatePassword(password, id);
		return ResponseEntity.ok().body(str);
	}
	
	/**
	 * to update the customer wallet balance
	 * @param wallet for the wallet amount
	 * @param id for the customer id
	 * @return ResponseEntity<String>
	 */
	@PutMapping("/customers/wallet/{wallet}/{id}")
	@Transactional
	public ResponseEntity<String> updateWallet(@PathVariable("wallet") double wallet, @PathVariable("id") long id) {
		String str = service.updateWallet(wallet, id);
		return ResponseEntity.ok().body(str);
	}
	
	/**
	 * to update the coupon
	 * @param coupon for the coupon
	 * @param id for the customer id
	 * @return ResponseEntity<String>
	 */
	@PutMapping("/customers/coupon/{coupon}/{id}")
	@Transactional
	public ResponseEntity<String> updateCoupon(@PathVariable("coupon") String coupon, @PathVariable("id") long id) {
		String str = service.updateCoupon(coupon, id);
		return ResponseEntity.ok().body(str);
	}
	
	/**
	 * to update the customer phone
	 * @param phone for the phone
	 * @param id for the customer id
	 * @return ResponseEntity<String>
	 */
	@PutMapping("/customers/phone/{phone}/{id}")
	@Transactional
	public ResponseEntity<String> updatePhone(@PathVariable("phone") String phone, @PathVariable("id") long id) {
		String str = service.updatePhone(phone, id);
		return ResponseEntity.ok().body(str);
	}
}
