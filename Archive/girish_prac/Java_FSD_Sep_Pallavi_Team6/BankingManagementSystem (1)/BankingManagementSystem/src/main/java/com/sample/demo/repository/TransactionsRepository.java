package com.sample.demo.repository;

import java.util.List;

import com.sample.demo.model.Account;
import com.sample.demo.model.Transactions;

public interface TransactionsRepository {
	public List<Transactions> viewAllTransaction();
	public List<Transactions> viewTransByAccNo(int accNo);
	public int addNewTrans(Transactions tran);
	public int updateTransStatus(Transactions status);
	public List<Transactions> viewTransByStatus(String st);
	
	
	

}
