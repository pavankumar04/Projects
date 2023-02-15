package com.Company.BMS.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Company.BMS.model.Account;
import com.Company.BMS.model.Transaction;
import com.Company.BMS.model.User;
import com.Company.BMS.repository.TransactionRepository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository{
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Transaction getLastRec() {
		String sql = "SELECT * FROM TRANSACTION ORDER BY TXNID DESC LIMIT 1";
		
		Transaction txn = null;
		try {
			txn = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Transaction.class));
		} catch (IncorrectResultSizeDataAccessException ex) {
			System.out.println("Table empty");
		}
		
		return txn;
	}


	@Override
	public List<Transaction> viewAllTxns(Account acct) {
		String sql = "SELECT * FROM TRANSACTION WHERE ACCTNO = ?";
		
		List<Transaction> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Transaction.class), acct.getAcctNo()); 
		return list;
	}

	@Override
	public int add(Transaction txn) {
		Transaction t = getLastRec();
		
		int id = 50001;
		
		if (t != null) {
			id = t.getTxnId()+ 1;
		}	
		
		Date date = Date.valueOf(txn.getTxnDate());
		String sql = "INSERT INTO TRANSACTION (TXNID, ACCTNO, OTHERSACCT, TXNDATE, TXNTYPE, TXNAMOUNT, BALANCE ) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		Object[] args = new Object[] {id, txn.getAcctNo(), txn.getOthersAcct(), date, txn.getTxnType().toString(), txn.getTxnAmount(), txn.getBalance() };
		
		int res = jdbcTemplate.update(sql, args);
		
		return res;
		
	}

}












