package com.Company.BMS.repository;

import java.util.List;

import com.Company.BMS.model.Recepient;

public interface RecepientRepository {
	public List<Recepient> viewAllRecepients();
	public Recepient findById(int id);
	public int add(Recepient recepient);
	public int deleteById(int id);
	public int updateAccountNo(Recepient recpt, long newAcctNo);

}
