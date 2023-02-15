package com.sample.demo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sample.demo.model.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {

	private DataSource datasource;
	
	public void setDataSource(DataSource datasource) {
		this.datasource = datasource;
	}
	@Override
	public List<Employee> getAll() {
		String sql = "SELECT * FROM EMPLOYEE";
		List<Employee> list = new ArrayList<Employee>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = datasource.getConnection();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Employee e = new Employee();
				e.setEmpId(rs.getInt("EMPID"));
				e.setFirstName(rs.getString("FIRSTNAME"));
				e.setLastName(rs.getString("LASTNAME"));
				e.setEmail(rs.getString("EMAIL"));
				e.setPhone(rs.getString("PHONE"));
				e.setDesignation(rs.getString("DESIGNATION"));
				list.add(e);
			}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{
			try {
				rs.close();
				stmt.close();
				con.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		return list;
	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
