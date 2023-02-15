package com.sample.demo.dao;

import java.util.List;

import com.sample.demo.model.Employee;

public interface IEmployeeDao {
	
	public List<Employee> getAll();
	public Employee getById(int id);
	
	public int save(Employee employee);
	
	public int update(Employee employee);
	
	public int deleteById(int id);
}
