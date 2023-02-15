package com.Company.BMS.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Company.BMS.model.Admin;
import com.Company.BMS.model.User;
import com.Company.BMS.repository.AdminRepository;

@Repository
public class AdminRepositoryImpl implements AdminRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public Admin findByEmail(String email) {
		String sql = "SELECT * FROM ADMIN WHERE EMAIL = ?";
		Admin admin = null;
		try {
			admin = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Admin.class), email);
		} catch (IncorrectResultSizeDataAccessException ex) {
			System.out.println(ex.getMessage());
		}
		return admin;
	}

	@Override
	public List<User> viewAllUsers() {
		String sql = "SELECT * FROM USER";
		
		List<User> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class)); 
		return list;
	}

	@Override
	public int updatePassword(Admin admin, String password) {
		String sql = "UPDATE ADMIN SET PASSWORD = ? WHERE EMAIL = ?";
		
		Object[] args = new Object[] {password, admin.getEmail()};
		
		int res = jdbcTemplate.update(sql, args);
		return res;	
	}

}
