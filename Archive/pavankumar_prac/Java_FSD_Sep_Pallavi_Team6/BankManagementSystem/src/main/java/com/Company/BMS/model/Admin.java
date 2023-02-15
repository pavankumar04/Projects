package com.Company.BMS.model;

public class Admin {
	private int adminId;
	private String adminName;
	private String email;
	private String password;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param adminId
	 * @param adminName
	 * @param email
	 * @param password
	 */
	public Admin(int adminId, String adminName, String email, String password) {
		this.adminId = adminId;
		this.adminName = adminName;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", email=" + email + ", password=" + password
				+ "]";
	}

	/**
	 * @return the adminId
	 */
	public int getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	/**
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}

	/**
	 * @param adminName the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	

	
	
	

}
