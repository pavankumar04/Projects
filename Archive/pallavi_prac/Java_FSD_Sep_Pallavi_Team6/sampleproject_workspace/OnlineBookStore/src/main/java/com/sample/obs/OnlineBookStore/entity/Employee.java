package com.sample.obs.OnlineBookStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Employee class.
 * @author Pallavi Prasad
 *
 */
@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name = "employeeid")
	private long employeeId;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "passcode")
	private String passcode;
	
	/**
	 * default constructor.
	 */
	public Employee() {
		
	}

	/**
	 * parameterized constructor.
	 * @param employeeId long
	 * @param firstName String
	 * @param lastName String
	 * @param phone String
	 * @param email String
	 * @param passcode String
	 */
	public Employee(long employeeId, String firstName, String lastName, String phone, String email, String passcode) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.passcode = passcode;
	}

	/**
	 * @return the employeeId
	 */
	public long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the passcode
	 */
	public String getPasscode() {
		return passcode;
	}

	/**
	 * @param passcode the passcode to set
	 */
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	/**
	 * toString method.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", email=" + email + ", passcode=" + passcode + "]";
	}
}
