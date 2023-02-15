package com.sample.demo.repository;

import java.util.List;

import com.sample.demo.model.Products;

public interface ProductRepository {
	public Products findById(int id);
	public List<Products> showAllProducts();
	
	public int save(Products product);
	public int update(Products product);
	public int deleteById(int id);
	
	public List<Products> listByName(String name);
}
