package com.sample.obs.OnlineBookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.obs.OnlineBookStore.entity.Employee;
import com.sample.obs.OnlineBookStore.repository.EmployeeRepository;

/**
 * Service class for Employee.
 * @author Pallavi Prasad
 *
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	/**
	 * to get employee details based on email.
	 * @param email for the email - String
	 * @return Employee object
	 */
	public Employee retrieveEmployeeByEmail(String email) {
		Employee e = repo.findByEmail(email);
		return e;
	}
	
	/**
	 * to get the employee details by id.
	 * @param id for the employee id - long
	 * @return Employee object
	 */
	public Employee retrieveEmployeeById(long id) {
		Employee e = repo.findById(id).get();
		return e;
	}
	
	/**
	 * to update password.
	 * @param pass for the new password - String
	 * @param id for the employee id - long
	 * @return String
	 */
	public String updatePassword(String pass, long id) {
		String msg = "Unable to update password";
		
		int res = repo.updatePassword(pass, id);
		
		if (res > 0) {
			msg = "Password updated";
		}
		
		return msg;
	}
	
	/**
	 * to update phone number.
	 * @param ph for the new phone number - String
	 * @param id for the employee id - long
	 * @return String
	 */
	public String updatePhone(String ph, long id) {
		String str = "Unable to update phone number";
		int res = repo.updatePhone(ph, id);
		
		if (res > 0) {
			str = "Phone number updated";
		}
		
		return str;
	}
}
