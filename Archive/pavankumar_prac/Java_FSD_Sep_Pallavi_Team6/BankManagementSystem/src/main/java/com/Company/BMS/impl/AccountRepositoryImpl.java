package com.Company.BMS.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Company.BMS.model.Account;
import com.Company.BMS.model.User;
import com.Company.BMS.repository.AccountRepository;

@Repository
public class AccountRepositoryImpl implements AccountRepository{
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	

	@Override
	public int add(Account acct) {
		String sql = "INSERT INTO ACCOUNT (ACCTNO, ACCTTYPE, USERID,  BALANCE) "+ "VALUES(?, ?, ?, ?)";
		
	
		Object[] args = new Object[] { acct.getAcctNo(), acct.getAcctType().toString(), acct.getUserId(), acct.getBalance()};
		
		int res = jdbcTemplate.update(sql, args);
		
		return res;
	}


	@Override
	public List<Account> viewAllAccountsOfUser(int userId) {
		String sql = "SELECT * FROM ACCOUNT WHERE USERID = ?";
		
		List<Account> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Account.class),userId); 
		return list;
	}

	@Override
	public int updateBalance(Account acct, double amt) {
		String sql = "UPDATE ACCOUNT SET BALANCE = ? WHERE ACCTNO = ?";
		
		Object[] args = new Object[] {amt, acct.getAcctNo()};
		
		int res = jdbcTemplate.update(sql, args);
		return res;
	}


	@Override
	public double viewBalance(long accNo) {
		String sql = "SELECT BALANCE FROM ACCOUNT WHERE ACCTNO = ?";
		
		Account ac = null;
		
		try {
			ac = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Account.class), accNo);
		} catch (IncorrectResultSizeDataAccessException ex) {
			System.out.println(ex.getMessage());
		}
		return ac.getBalance();
	}


	

}
