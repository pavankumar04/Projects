package com.sample.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.demo.model.Products;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Products findById(int id) {
		String sql = "SELECT * FROM PRODUCTS WHERE PRODUCTID = ?";
		
		Products product = null;
		
		try {
			product = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Products.class), id);
		} catch (IncorrectResultSizeDataAccessException ex) {
			System.out.println("Product Not Found");
		}
		
		return product;
	}

	@Override
	public List<Products> showAllProducts() {
		String sql = "SELECT * FROM PRODUCTS";
		
		List<Products> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Products.class)); 
		return list;
	}

	private Products getLastRec() {
		String sql = "SELECT * FROM PRODUCTS ORDER BY PRODUCTID DESC LIMIT 1";
		
		Products p = null;
		try {
			p = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Products.class));
		} catch (IncorrectResultSizeDataAccessException ex) {
			System.out.println("Table empty");
		}
		return p;
	}
	@Override
	public int save(Products product) {
		String sql = "INSERT INTO PRODUCTS (PRODUCTID, PRODUCTNAME, DESCRIPTION, BRAND, PRICE) "
				+ "VALUES(?, ?, ?, ?, ?)";
		
		Products p = getLastRec();
		int id = 101;
		
		if(p != null) {
			id = p.getProductId() + 1;
		}
		
		Object[] args = new Object[] {id, product.getProductName(), product.getDescription(), product.getBrand(),
				product.getPrice()};
		int res = jdbcTemplate.update(sql, args);
		
		return res;
	}

	@Override
	public int update(Products product) {
		String sql = "UPDATE PRODUCTS SET PRICE = ? WHERE PRODUCTID = ?";
		
		Object[] args = new Object[] {product.getPrice(), product.getProductId()};
		
		int res = jdbcTemplate.update(sql, args);
		
		return res;
	}

	@Override
	public int deleteById(int id) {
		String sql = "DELETE FROM PRODUCTS WHERE PRODUCTID = ?";
		
		int res = jdbcTemplate.update(sql, id);
		return res;
	}

	@Override
	public List<Products> listByName(String name) {
		String sql = "SELECT * FROM PRODUCTS WHERE PRODUCTNAME = ?";
		
		List<Products> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Products.class), name);
		
		return list;
	}
	
}
