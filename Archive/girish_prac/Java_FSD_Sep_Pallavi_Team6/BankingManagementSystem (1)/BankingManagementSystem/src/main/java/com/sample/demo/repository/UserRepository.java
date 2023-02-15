package com.sample.demo.repository;

import java.util.List;

import com.sample.demo.model.Users;

public interface UserRepository {
	public int register(Users user);
	public int updatePhoneNumber(Users user);
	public Users viewAccDetails(int phoneNumber);
	public List<Users> retrieveAllUsers();
	public int updateEmail(Users user);
	//public int updateBalance(Users user);
	
}
