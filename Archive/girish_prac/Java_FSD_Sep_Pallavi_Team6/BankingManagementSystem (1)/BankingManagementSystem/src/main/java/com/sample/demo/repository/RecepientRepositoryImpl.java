package com.sample.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.demo.model.Recepient;

@Repository
public class RecepientRepositoryImpl implements RecepientRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public List<Recepient> RetrieveAllRecDetails() {					
		String sql = "SELECT * FROM RECEPIENT";       
	    List<Recepient> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Recepient.class)); 
	    return list;
			
		
	}
				
	
	@Override
	public int addRecepient(Recepient rec) {
		
		String sql = "INSERT INTO RECEPIENT ( NAME,PHONENUMBER, ACCOUNTNUMBER) "
                + "VALUES (?, ?, ?)";
        
        Object[] args = new Object[] {rec.getName(), rec.getPhoneNumber(), rec.getAccountNumber()};
        int res = jdbcTemplate.update(sql, args);
        
        return res;				
	}


	@Override
	public Recepient findByAccNumber(int acNumber) {
		String sql="SELECT * FROM RECEPIENT WHERE ACCOUNTNUMBER=?";
		
		Recepient recepient=jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Recepient.class),acNumber);
		return recepient;
	}
	

}
