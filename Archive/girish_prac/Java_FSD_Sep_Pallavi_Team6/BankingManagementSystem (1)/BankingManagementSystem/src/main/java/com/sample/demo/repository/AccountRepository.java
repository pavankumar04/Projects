package com.sample.demo.repository;

import java.util.List;

import com.sample.demo.model.Account;

public interface AccountRepository {
	public List<Account> viewAllAccounts();
	public Account findByEmail(String email);
	public int updateBalance(double balance,Account acc2);
	public int updatePassword(Account acc);
	public int updateRole(Account acc);
	public Account  showBalance(int accNo);
	public int deleteAcc(int accNo);
	public int addAccount(Account acc);
	public Account findByAccNumber(int acNumber);
	

}
