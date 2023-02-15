package com.Company.BMS.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Company.BMS.model.Recepient;
import com.Company.BMS.model.Transaction;
import com.Company.BMS.model.User;
import com.Company.BMS.repository.RecepientRepository;


@Repository
public class RecepientRepositoryImpl implements RecepientRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private Recepient getLastRec() {
		String sql = "SELECT * FROM RECEPIENT ORDER BY RCPTID DESC LIMIT 1";
		
		Recepient recpt = null;
		try {
			recpt = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Recepient.class));
		} catch (IncorrectResultSizeDataAccessException ex) {
			System.out.println("Table empty");
		}
		
		return recpt;
	}


	@Override
	public List<Recepient> viewAllRecepients() {
		String sql = "SELECT * FROM RECEPIENT";
		
		List<Recepient> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Recepient.class)); 
		return list;
	}

	@Override
	public int add(Recepient recpt) {
		 Recepient r = getLastRec();
		
		int id = 40001;
		
		if (r != null) {
			id = r.getRcptId()+ 1;
		}	
		
		String sql = "INSERT INTO RECEPIENT (RCPTID, ACCTNO, NAME, PHONENO, BANKTYPE ) "
				+ "VALUES(?, ?, ?, ?, ?)";
		
		Object[] args = new Object[] {id, recpt.getAcctNo(), recpt.getName(), recpt.getPhoneNo(), recpt.getBankType().toString() };
		
		int res = jdbcTemplate.update(sql, args);
		
		return res;
	}

	@Override
	public int deleteById(int id) {
		String sql = "DELETE FROM RECEPIENT WHERE RCEPTID = ?";
		int res = jdbcTemplate.update(sql, id);
		return res;
	}

	@Override
	public int updateAccountNo(Recepient recpt , long newAcctNo) {
		String sql = "UPDATE RECEPIENT SET ACCTNO = ? WHERE RCPTID = ?";
		
		Object[] args = new Object[] {newAcctNo, recpt.getRcptId() };
		
		int res = jdbcTemplate.update(sql, args);
		return res;	
	}


	@Override
	public Recepient findById(int id) {
		
		String sql = "SELECT * FROM RECEPIENT WHERE RCPTID = ?";
		
		Recepient rc = null;
		
		try {
			rc = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Recepient.class), id);
		} catch (IncorrectResultSizeDataAccessException ex) {
			System.out.println(ex.getMessage());
		}
				
		return rc;
	}
	
	
	

}
