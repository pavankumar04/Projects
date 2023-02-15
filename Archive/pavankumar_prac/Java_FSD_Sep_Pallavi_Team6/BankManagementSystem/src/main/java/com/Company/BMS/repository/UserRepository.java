package com.Company.BMS.repository;

import com.Company.BMS.model.User;

public interface UserRepository {
	
	public boolean validate(String username, String password);
	public int add(User user);
	public int deleteById(int id);
	public int updatePassword(User user, String password);
//	public User getLastRec();
	
	public User findByUsername(String username);
	

}
