package com.Company.BMS.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Company.BMS.model.User;
import com.Company.BMS.repository.UserRepository;


@Repository
public class UserRepositoryImpl implements UserRepository{
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User findByUsername(String username) {
		String sql = "SELECT * FROM USER WHERE username = ?";
		
		User user = null;
		
		try {
			user = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), username);
		} catch (IncorrectResultSizeDataAccessException ex) {
			System.out.println(ex.getMessage());
		}
				
		return user;
	}
	
	private User getLastRec() {
		String sql = "SELECT * FROM USER ORDER BY USERID DESC LIMIT 1";
		
		User user = null;
		try {
			user = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class));
		} catch (IncorrectResultSizeDataAccessException ex) {
			System.out.println("Table empty");
		}
		
		return user;
	}

	@Override
	public boolean validate(String username, String password) {
		
		User user = findByUsername(username);
		
//		if(user != null) {
//			System.out.println("Please register to continue");
//		}
//		else if(user.getPassword().equals(password)){
//			System.out.println("Welcome to Our Banking Network");
//		}
//		else {
//			System.out.println("Username or Password mismatch");
//		}
		
		if(user.getPassword().equals(password)){
			return true;
		}
		else {
			return false;
		}

	}

	@Override
	public int add(User user) {
		User u = getLastRec();
		int id = 30001;
		
		if (u != null) {
			id = u.getUserId() + 1;
		}
		
		String sql = "INSERT INTO USER (USERID, FIRSTNAME, LASTNAME, USERNAME, PASSWORD, EMAIL, PHONENO, PANNO, DOB, AADHARNO, ADDRESS, CITY) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Date date = Date.valueOf(user.getDob());
		Object[] args = new Object[] {id, user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword() ,user.getEmail(), 
				user.getPhoneNo(), user.getPanNo(), date , user.getAadharNo(), user.getAddress(), user.getCity() };
		
		int res = jdbcTemplate.update(sql, args);
		
		return res;
		
	}

	@Override
	public int deleteById(int id) {
		String sql = "DELETE FROM USER WHERE USERID = ?";
		int res = jdbcTemplate.update(sql, id);
		return res;
	}

	@Override
	public int updatePassword(User user, String password) {
		String sql = "UPDATE USER SET PASSWORD = ? WHERE USERID = ?";
		
		Object[] args = new Object[] {password, user.getUserId()};
		
		int res = jdbcTemplate.update(sql, args);
		return res;
	}

}
