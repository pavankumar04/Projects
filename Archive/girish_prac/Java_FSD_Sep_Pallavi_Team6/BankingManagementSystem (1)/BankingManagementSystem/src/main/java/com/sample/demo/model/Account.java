package com.sample.demo.model;

public class Account {
	private int accountNumber;
	private String email;
	private String password;
	private String role;
	private double balance;
	
	public Account () {
		
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

	public Account(int accountNumber, String email, String password, String role, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.email = email;
		this.password = password;
		this.role = role;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", email=" + email + ", password=" + password
				+ ", role=" + role + ", balance=" + balance + "]";
	}
	
	

}
