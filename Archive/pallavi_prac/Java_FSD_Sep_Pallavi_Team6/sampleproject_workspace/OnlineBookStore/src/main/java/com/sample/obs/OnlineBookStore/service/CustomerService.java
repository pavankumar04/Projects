package com.sample.obs.OnlineBookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.obs.OnlineBookStore.entity.Customer;
import com.sample.obs.OnlineBookStore.exceptions.ResourceNotFoundException;
import com.sample.obs.OnlineBookStore.repository.CustomerRepository;

/**
 * Service class for Customer.
 * @author Pallavi Prasad
 *
 */
@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;
	
	/**
	 * to get a list of customers
	 * @return list of customers
	 */
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}
	
	/**
	 * To get customer details based on email.
	 * @param email for the email String
	 * @return Customer object
	 * @throws ResourceNotFoundException for the exception
	 */
	public Customer retrieveByEmail(String email) throws ResourceNotFoundException {
		Customer c = repo.findByEmail(email);
		
		if (c == null) {
			throw new ResourceNotFoundException("Customer with email: " + email + " not found");
		}
		
		return c;
	}
	
	/**
	 * to get customer details based on customer id
	 * @param id for the customer id - long
	 * @return Customer object
	 * @throws ResourceNotFoundException for the exception
	 */
	public Customer retrieveCustomerById(long id) throws ResourceNotFoundException {
		Customer c = repo.findById(id).get();
		
		if (c == null) {
			throw new ResourceNotFoundException("Customer with id: " + id + " not found");
		}
		return c;
	}
	
	/**
	 * to add new customer details.
	 * @param customer for the customer object
	 * @return Customer object
	 */
	public Customer saveCustomer(Customer customer) {
		//String str = "Unable to upload customer details";
		Customer c = repo.findTopByOrderByCustomerIdDesc();
		
		long id = 101;
		if (c != null) {
			id = c.getCustomerId() + 1;
			
		}
		customer.setCustomerId(id);
		
		c = repo.save(customer);
		
		return c;
	}
	
	/**
	 * to update password.
	 * @param pass for the new password - String
	 * @param id for the customer id - long
	 * @return String
	 */
	public String updatePassword(String pass, long id) {
		String str = "Unable to update password";
		
		int res = repo.updatePassword(pass, id);
		if(res > 0) {
			str = "Password updated";
		}
		
		return str;
	}
	
	/**
	 * to update phone number.
	 * @param ph for the new phone number - String
	 * @param id for the customer id - long
	 * @return String
	 */
	public String updatePhone(String ph, long id) {
		String str = "Unable to update Phone number";
		
		int res = repo.updatePhone(ph, id);
		if(res > 0) {
			str = "Phone number updated";
		}
		
		return str;
	}
	
	/**
	 * to update the wallet amount
	 * @param wallet for the wallet amount
	 * @param id for the customer id
	 * @return String
	 */
	public String updateWallet(double wallet, long id) {
		String str = "Unable to update wallet";
		
		int res = repo.updateWalletAmount(wallet, id);
		if(res > 0) {
			str = "Wallet amount updated";
		}
		
		return str;
	}
	
	/**
	 * to update the coupon
	 * @param coupon for the coupon
	 * @param id for the customer id
	 * @return String
	 */
	public String updateCoupon(String coupon, long id) {
		String str = "Unable to update coupon";
		
		int res = repo.updateCoupon(id, coupon);
		
		if(res > 0) {
			str = "Coupon updated";
		}
		
		return str;
	}
	
	/**
	 * to update the address
	 * @param addr for the address
	 * @param id for the customer id
	 * @return String
	 */
	public String updateAddress(String addr, long id) {
		String str = "Unable to update address";
		
		int res = repo.updateAddress(id, addr);
		
		if(res > 0) {
			str = "Address updated";
		}
		
		return str;
	}
}
