package com.sample.demo.model;

public class Users {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String passcode;
	private String userType;
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPasscode() {
		return passcode;
	}
	
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	
	public String getUserType() {
		return userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", passcode=" + passcode + ", userType=" + userType + "]";
	}
	
	public Users() {
		
	}
	
	public Users(int userId, String firstName, String lastName, String email, String passcode, String userType) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passcode = passcode;
		this.userType = userType;
	}
	
	
}
