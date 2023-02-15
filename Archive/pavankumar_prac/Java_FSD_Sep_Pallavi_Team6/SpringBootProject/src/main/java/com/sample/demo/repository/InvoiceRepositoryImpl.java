package com.sample.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.demo.model.Invoice;

@Repository
public class InvoiceRepositoryImpl implements InvoiceRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Invoice inv) {
		String sql = "INSERT INTO INVOICE (INVID, INVDATE, USERID, PRODUCTID, AMOUNT, QTY) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		Invoice invoice = getLastRec();
		
		int id = 201;
		
		if (invoice != null) {
			id = invoice.getInvId()  + 1;
		}
		
		Date d = Date.valueOf(inv.getInvDate());
		//System.out.println(d);
		
		Object[] args = new Object[] {id, d, inv.getUserId(), inv.getProductId(), inv.getAmount(), inv.getQty()};
		
		int res = jdbcTemplate.update(sql, args);
		
		return res;
	}

	@Override
	public Invoice findById(int id) {
		String sql = "SELECT * FROM INVOICE WHERE INVID = ?";
		
		Invoice inv = null;
		try {
			inv = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Invoice.class), id);
		} catch (IncorrectResultSizeDataAccessException ex) {
			System.out.println("Invoice not found");
		}
		
		return inv;
	}

	@Override
	public List<Invoice> listInvoicesForUser(int id) {
		String sql = "SELECT * FROM INVOICE WHERE USERID = ?";
		
		List<Invoice> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Invoice.class), id);
		return list;
	}

	@Override
	public List<Invoice> listByDate(LocalDate date) {
		String sql = "SELECT * FROM INVOICE WHERE INVDATE = ?";
		
		Date d = Date.valueOf(date);
		
		List<Invoice> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Invoice.class), d);
		return list;
	}

	private Invoice getLastRec() {
		String sql = "SELECT * FROM INVOICE ORDER BY INVID DESC LIMIT 1";
		
		Invoice inv = null;
		try {
			inv = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Invoice.class));
		} catch (IncorrectResultSizeDataAccessException ex) {
			System.out.println("Table is empty");
		}
		return inv;
	}

	@Override
	public List<Invoice> showAllPurchases() {
		String sql = "SELECT * FROM INVOICE";
		
		List<Invoice> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Invoice.class));
		return list;
	}

	@Override
	public List<Invoice> listAllByProduct(int id) {
		String sql = "SELECT * FROM INVOICE WHERE PRODUCTID = ?";
		
		List<Invoice> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Invoice.class), id);
		return list;
	}

	@Override
	public List<Invoice> listPurchasesForToday() {
		String sql = "SELECT * FROM INVOICE WHERE INVDATE = CURDATE()";
		
		List<Invoice> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Invoice.class));
		return list;
	}
}
