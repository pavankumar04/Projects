package com.sample.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.demo.model.Account;
import com.sample.demo.model.Users;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	

	@Override
	public int register(Users user) {
		String sql = "INSERT INTO USERS (FIRSTNAME, LASTNAME, EMAIL, PHONENUMBER, PANNUMBER, AADHARNUMBER, ADDRESS, CITY) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Object[] args = new Object[] { user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(),
        		user.getPanNumber(), user.getAadharNumber(), user.getAddress(), user.getCity() };
        int res = jdbcTemplate.update(sql, args);
        
        return res;				
	}

	@Override
	public int updatePhoneNumber(Users user) {
		
		 String sql = "UPDATE USERS SET PHONENUMBER = ? WHERE PANNUMBER = ?";
		 
	     Object[] args = new Object[] {user.getPhoneNumber(), user.getPanNumber()};
	        
	     int res = jdbcTemplate.update(sql, args);
	     return res;	    	
	}

	@Override
	public Users viewAccDetails(int phoneNumber) {
        String sql = "SELECT * FROM USERS WHERE PHONENUMBER = ?";       
        Users user = null;
        
        try {
            user = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Users.class), phoneNumber);
        } catch (IncorrectResultSizeDataAccessException ex) {
            System.out.println(ex.getMessage());
        }
                
        return user;
	}

	@Override
	public List<Users> retrieveAllUsers() {
        String sql = "SELECT * FROM USERS";       
        List<Users> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Users.class)); 
        return list;
		
		
	}

	@Override
	public int updateEmail(Users user) {
		String sql = "UPDATE USERS SET EMAIL = ? WHERE PANNUMBER = ?";
		 
	     Object[] args = new Object[] {user.getEmail(), user.getPanNumber()};
	        
	     int res = jdbcTemplate.update(sql, args);
	     return res;	    	
		
		
	}

	
}
