package com.sample.demo.repository;

import com.sample.demo.model.Users;

public interface UserRepository {
	public Users findByEmail(String email);
	public Users findById(int id);
	
	public int save(Users user);
	public int updatePassword(Users user);
	public int deleteById(int id);
}
