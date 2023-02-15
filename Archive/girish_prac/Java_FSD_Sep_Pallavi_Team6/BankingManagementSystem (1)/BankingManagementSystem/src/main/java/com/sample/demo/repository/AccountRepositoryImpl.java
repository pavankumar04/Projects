package com.sample.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.demo.model.Account;



@Repository
public class AccountRepositoryImpl implements AccountRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private Account getLastAcc() {
		String sql = "SELECT * FROM ACCOUNT ORDER BY ACCOUNTNUMBER DESC LIMIT 1";
		Account acc = null;
		try {
			acc = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Account.class));
		} catch (IncorrectResultSizeDataAccessException ex) {
			System.out.println(ex.getMessage());
		}
		return acc;
		
	}
	@Override
	public List<Account> viewAllAccounts() {
		String sql = "SELECT * FROM ACCOUNT";
		List<Account> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Account.class)); 
        return list;
		
	
	}

	@Override
	public Account findByEmail(String email) {
		String sql = "SELECT * FROM ACCOUNT WHERE EMAIL = ?";       
        Account acc = null;
        
        try {
            acc = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Account.class), email);
        } catch (IncorrectResultSizeDataAccessException ex) {
            System.out.println(ex.getMessage());
        }
                
        return acc;
	}
	

	

	@Override
	public int updatePassword(Account acc) {
		
         String sql = "UPDATE ACCOUNT SET PASSWORD = ? WHERE ACCOUNTNUMBER = ?";		 
	     Object[] args = new Object[] {acc.getPassword(),acc.getAccountNumber()};
	        
	     int res = jdbcTemplate.update(sql, args);
	     return res;
	}

	@Override
	public int updateRole(Account acc) {
		 String sql = "UPDATE ACCOUNT SET ROLE = ? WHERE ACCOUNTNUMBER = ?";		 
	     Object[] args = new Object[] {acc.getRole(),acc.getAccountNumber()};
	        
	     int res = jdbcTemplate.update(sql, args);
	     return res;
	     
	}

	@Override
	public Account showBalance(int accNo) {
		
		String sql = "SELECT BALANCE FROM ACCOUNT WHERE ACCOUNTNUMBER = ?";       
        Account acc = null;
        
        try {
            acc = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Account.class), accNo);
        } catch (IncorrectResultSizeDataAccessException ex) {
            System.out.println(ex.getMessage());
        }               
        return acc;
	}

	@Override
	public int deleteAcc(int accNo) {
		String sql = "DELETE FROM ACCOUNT WHERE ACCOUNTNUMBER = ? ";
		
		int res = jdbcTemplate.update(sql,accNo);
		
		return res;
	}

	@Override
	public int addAccount(Account acc) {				
		String sql = "INSERT INTO ACCOUNT(ACCOUNTNUMBER, EMAIL, PASSWORD, ROLE, BALANCE) "
                + "VALUES (?, ?, ?, ?, ?)";
		Account accNo = getLastAcc();
		int No = 101;
		if(accNo != null) {
			No = accNo.getAccountNumber()+ 1;
		}
		       
        Object[] args = new Object[] {No, acc.getEmail(),acc.getPassword(), acc.getRole(), acc.getBalance() };
        int res = jdbcTemplate.update(sql, args);
        
        return res;	
	}
	@Override
	public Account findByAccNumber(int acNumber) {
		String sql="SELECT * FROM ACCOUNT WHERE ACCOUNTNUMBER=?";
		Account account=jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Account.class),acNumber);
		
		return account;
	}
	@Override
	public int updateBalance(double balance,Account acNumber) {
		String sql="UPDATE ACCOUNT SET BALANCE=? WHERE ACCOUNTNUMBER=?";
		
		Object [] args=new Object[] {balance,acNumber.getAccountNumber()};
		int res=jdbcTemplate.update(sql,args);
		return res;
	}
}
