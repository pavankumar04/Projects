package com.sample.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.demo.model.Users;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Users findByEmail(String email) {
		String sql = "SELECT * FROM USERS WHERE EMAIL = ?";
		
		Users user = null;
		
		try {
			user = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Users.class), email);
		} catch (IncorrectResultSizeDataAccessException ex) {
			System.out.println(ex.getMessage());
		}
				
		return user;
	}

	@Override
	public Users findById(int id) {
		String sql = "SELECT * FROM USERS WHERE USERID = ?";
		
		Users user = null;
		
		try {
			user = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Users.class), id);
		} catch (IncorrectResultSizeDataAccessException ex) {
			System.out.println(ex.getMessage());
		}
				
		return user;
	}
	
	private Users getLastRec() {
		String sql = "SELECT * FROM USERS ORDER BY USERID DESC LIMIT 1";
		
		Users user = null; 
		try {
			user = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Users.class));
		} catch (IncorrectResultSizeDataAccessException ex) {
			System.out.println("Table empty");
		}
		return user;
	}

	@Override
	public int save(Users user) {
		Users u = getLastRec();
		int id = 1;
		
		if (u != null) {
			id = u.getUserId() + 1;
		}
		
		String sql = "INSERT INTO USERS (USERID, FIRSTNAME, LASTNAME, EMAIL, PASSCODE, USERTYPE) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		Object[] args = new Object[] {id, user.getFirstName(), user.getLastName(), user.getEmail(),
				user.getPasscode(), user.getUserType()};
		int res = jdbcTemplate.update(sql, args);
		
		return res;
	}

	@Override
	public int updatePassword(Users user) {
		String sql = "UPDATE USERS SET PASSCODE = ? WHERE USERID = ?";
		
		Object[] args = new Object[] {user.getPasscode(), user.getUserId()};
		
		int res = jdbcTemplate.update(sql, args);
		return res;
	}

	@Override
	public int deleteById(int id) {
		String sql = "DELETE FROM USERS WHERE USERID = ?";
		
		int res = jdbcTemplate.update(sql, id);
		return res;
	}

}
