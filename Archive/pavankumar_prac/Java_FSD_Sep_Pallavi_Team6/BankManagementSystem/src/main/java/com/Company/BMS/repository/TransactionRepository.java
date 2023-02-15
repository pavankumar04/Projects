package com.Company.BMS.repository;

import java.util.List;

import com.Company.BMS.model.Account;
import com.Company.BMS.model.Transaction;

public interface TransactionRepository {
	public List<Transaction> viewAllTxns(Account acct);
	public int add(Transaction txn);
	
	

}
