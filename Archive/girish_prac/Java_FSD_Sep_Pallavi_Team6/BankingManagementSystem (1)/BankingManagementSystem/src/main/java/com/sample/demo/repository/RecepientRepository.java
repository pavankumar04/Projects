package com.sample.demo.repository;

import java.util.List;

import com.sample.demo.model.Recepient;

public interface RecepientRepository {
	public List<Recepient> RetrieveAllRecDetails();
	public int addRecepient(Recepient rec);
	public Recepient findByAccNumber(int rac);


}
