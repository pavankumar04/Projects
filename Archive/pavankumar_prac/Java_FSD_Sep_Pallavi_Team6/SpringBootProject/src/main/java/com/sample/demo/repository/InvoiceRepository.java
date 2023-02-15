package com.sample.demo.repository;

import java.time.LocalDate;
import java.util.List;

import com.sample.demo.model.Invoice;

public interface InvoiceRepository {
	public int save(Invoice inv);
	public Invoice findById(int id);
	
	public List<Invoice> listInvoicesForUser(int id);
	public List<Invoice> listByDate(LocalDate date);
	
	public List<Invoice> showAllPurchases();
	
	public List<Invoice> listAllByProduct(int id);
	
	public List<Invoice> listPurchasesForToday();
}
