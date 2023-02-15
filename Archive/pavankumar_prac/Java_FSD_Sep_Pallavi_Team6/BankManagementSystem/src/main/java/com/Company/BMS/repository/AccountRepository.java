package com.Company.BMS.repository;

import java.util.List;

import com.Company.BMS.model.Account;

public interface AccountRepository {
	public List<Account> viewAllAccountsOfUser(int userId);
	public int add(Account acct);
	public int updateBalance(Account acct, double amt);
	public double viewBalance(long accNo);


	
	
	
	
	
	

}
