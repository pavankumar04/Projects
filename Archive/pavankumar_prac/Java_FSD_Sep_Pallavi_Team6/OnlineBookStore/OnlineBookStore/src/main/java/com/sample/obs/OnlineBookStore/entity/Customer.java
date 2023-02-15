package com.sample.obs.OnlineBookStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Customer class.
 * @author Pallavi Prasad
 *
 */
@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@Column(name = "customerid")
	private long customerId;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "wallet")
	private double wallet;
	
	@Column(name = "passcode")
	private String passcode;
	
	@Column(name = "coupon")
	private String coupon;
	
	/**
	 * default constructor.
	 */
	public Customer() {
		
	}

	/**
	 * parameterized constructor.
	 * @param customerId long
	 * @param firstName String
	 * @param lastName String
	 * @param address String
	 * @param phone String
	 * @param email String
	 * @param wallet double
	 * @param passcode String
	 * @param coupon String
	 */
	public Customer(long customerId, String firstName, String lastName, String address, String phone, String email, double wallet,
			String passcode, String coupon) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.wallet = wallet;
		this.passcode = passcode;
		this.coupon = coupon;
	}

	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @return the wallet
	 */
	public double getWallet() {
		return wallet;
	}

	/**
	 * @param wallet the wallet to set
	 */
	public void setWallet(double wallet) {
		this.wallet = wallet;
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
	 * @return the coupon
	 */
	public String getCoupon() {
		return coupon;
	}

	/**
	 * @param coupon the coupon to set
	 */
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	/**
	 * toString method.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + ", wallet=" + wallet
				+ ", passcode=" + passcode + ", coupon=" + coupon + "]";
	}
}
