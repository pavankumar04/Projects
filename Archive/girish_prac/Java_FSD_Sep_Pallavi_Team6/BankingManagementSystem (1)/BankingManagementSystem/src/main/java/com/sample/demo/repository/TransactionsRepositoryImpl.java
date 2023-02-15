package com.sample.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.demo.model.Account;
import com.sample.demo.model.Transactions;

@Repository
public class TransactionsRepositoryImpl implements TransactionsRepository {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private Transactions getLastTranId() {
		String sql = "SELECT * FROM TRANSACTIONS ORDER BY TRANSACTIONID DESC LIMIT 1";
		Transactions tran = null;
		try {
			tran = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Transactions.class));
		} catch (IncorrectResultSizeDataAccessException ex) {
			System.out.println(ex.getMessage());
		}
		return tran;
		
	}

	@Override
	public List<Transactions> viewAllTransaction() {
		String sql = "SELECT * FROM TRANSACTIONS";
		List<Transactions> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Transactions.class)); 
        return list;
	}

	@Override
	public List<Transactions> viewTransByAccNo(int accNo) {
		
	    String sql = "SELECT * FROM TRANSACTIONS WHERE ACCOUNTNUMBER = ?";       
	    List<Transactions> transactions = null;
	        
	    try {
	    	transactions = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Transactions.class), accNo);
        } catch (IncorrectResultSizeDataAccessException ex) {
            System.out.println(ex.getMessage());
        }
                
        return transactions;
	    }

	@Override
	public int addNewTrans(Transactions tran) {
		String sql = "INSERT INTO TRANSACTIONS(TRANSACTIONID, ACCOUNTNUMBER, TRANSACTIONTYPE, TRANSACTIONSTATUS,SECONDACCOUNT, TRANSACTIONDATE) "
                + "VALUES (?, ?, ?, ?,?,?)";
		Transactions accNo = getLastTranId();
		int No = 01;
		if(accNo != null) {
			No = accNo.getAccountNumber()+ 1;
		}
		       
        Object[] args = new Object[] {No, tran.getAccountNumber(), tran.getTransactionType(),tran.getTransactionStatus(), tran.getSecondAccount()
        		,tran.getTransactionDate(),
        		};
        int res = jdbcTemplate.update(sql, args);
        
        return res;	
	}

	@Override
	public int updateTransStatus(Transactions status) {
		 String sql = "UPDATE TRANSACTIONS SET TRANSACTIONSTATUS = ? WHERE TRANSACTIONID = ?";
		 
	     Object[] args = new Object[] {status.getTransactionStatus(), status.getTransactionId()};
	        
	     int res = jdbcTemplate.update(sql, args);
	     return res;
	
	}

	@Override
	public List<Transactions> viewTransByStatus(String st) {
		String sql = "SELECT * FROM TRANSACTIONS WHERE TRANSACTIONSTATUS = ?";       
	    List<Transactions> transactions = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Transactions.class));    
        return transactions;
		
	}

	
	    	
	           	    
		
	

}
