package com.Company.BMS.repository;

import java.util.List;

import com.Company.BMS.model.Admin;
import com.Company.BMS.model.User;

public interface AdminRepository {
	public int updatePassword(Admin admin,String password);
	public Admin findByEmail(String email);
	public List<User> viewAllUsers();

}
