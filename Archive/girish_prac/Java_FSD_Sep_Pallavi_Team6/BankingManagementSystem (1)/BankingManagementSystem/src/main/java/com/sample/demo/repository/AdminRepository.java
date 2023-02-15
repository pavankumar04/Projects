package com.sample.demo.repository;

import com.sample.demo.model.Admin;

public interface AdminRepository {
	public int updatePassword(Admin admin);
	
	public Admin findById(int id);
	

}
