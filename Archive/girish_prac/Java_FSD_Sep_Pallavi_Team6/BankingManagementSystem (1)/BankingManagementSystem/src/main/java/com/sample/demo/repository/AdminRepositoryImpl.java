package com.sample.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.demo.model.Admin;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public int updatePassword(Admin admin) {
		
	String sql = "UPDATE ADMIN SET ADMINPASSWORD = ? WHERE ADMINID = ?";		 		    		
	Object[] args = new Object[] {admin.getAdminPassword(),admin.getAdminId()};		        		     
	int res = jdbcTemplate.update(sql, args);		     
	return res;
		
		   
	}

	@Override
	public Admin findById(int id) {
			
	    String sql = "SELECT * FROM ADMIN WHERE ADMINID = ?";       
	    Admin adm = null;
	        
	    try {
	    	
	        adm = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Admin.class),id );
	    } catch (IncorrectResultSizeDataAccessException ex) {
	    	
	        System.out.println(ex.getMessage());
	    }
	                
	    return adm;
    }
			
	

}
