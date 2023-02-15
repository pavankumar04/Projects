package com.sample.JDBCProject2.persistance;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;

import java.sql.Statement;
import com.sample.JDBCProject2.model.Actor;
import com.sample.JDBCProject2.model.Gender;

public class ActorDb {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/actordb?allowPublicKeyRetrieval=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "Password123";
	
	public static List<Actor> retrieveAll(){
		String sql = "SELECT * FROM ACTOR";
		
		List<Actor> list = new ArrayList<Actor>();
		
		try {
			
//			register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			create the connection
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			
//			create the sql statement
			Statement stmt = con.createStatement();
			
//			execute query
			ResultSet rs = stmt.executeQuery(sql);
			
//			process the result set
			while(rs.next()){
				Actor a = new Actor();
				
//				a.setActorId(rs.getInt(ActorID));
				int id = rs.getInt("ActorID");
				a.setActorId(id);
				
				a.setFirstName(rs.getString("FIRSTNAME"));
				a.setLastName(rs.getString("LASTNAME"));
				
				String g = rs.getString("GENDER");
				Gender gen = Gender.valueOf(g);
				
				a.setGender(gen);
				
				Date dob = rs.getDate("DOB");
				LocalDate Id = dob.toLocalDate();
				a.setDob(Id);
				
				a.setPhone(rs.getString("PHONE"));
				a.setFees(rs.getDouble("FEES"));
				
				list.add(a);
						
			}
			
//			close connections
			con.close();
			
		}catch(ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch(SQLException ex) {		
			System.out.println(ex.getMessage());		
		}
		return list;
	}
	public static Actor findById(int id) {
		Actor actor = new Actor();
		String sql = "SELECT * FROM ACTOR WHERE ACTORID = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,  id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				actor.setActorId(rs.getInt("ACTORID"));
				actor.setFirstName(rs.getString("FIRSTNAME"));
				actor.setLastName(rs.getString("LASTNAME"));
//				convert string to enum
				String g = rs.getString("GENDER");
				Gender gen = Gender.valueOf(g);
				
				actor.setGender(gen);
				
//				convert java.sql.date to java.time.localdate
				Date dob = rs.getDate("DOB");
				LocalDate Id = dob.toLocalDate();
				actor.setDob(Id);
				
				actor.setPhone(rs.getString("PHONE"));
				actor.setFees(rs.getDouble("FEES"));
			}
		}catch(ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch(SQLException ex) {		
			System.out.println(ex.getMessage());		
		}
		return actor;
	}
	private static int getLastId() {
		int id = 0;
		String sql = "SELECT ACTORID FROM ORDER BY ACTORID DESC LIMIT 1";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			
			Statement stmt = con.createStatement();
			
		}catch(ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch(SQLException ex) {		
			System.out.println(ex.getMessage());		
		}
		return id;
	}
	
	public static int insertIntoDb(String fName, String lName, String ph, double fees, Date dob, String gender) {
		String sql = "INSERT INTO ACTOR (ACTORID, FIRSTNAME, LASTNAME, PHONE, DOB, GENDER, FEES)" +
				"VALUES (?, ?, ?, ?, ?, ?. ?)";
		
		int res = 0;
		int id = getLastId();
		
		if(id == 0) {
			id = 1;
		}else {
			++id;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, fName);
			ps.setString(3, lName);
			ps.setString(4, ph);
			ps.setDate(5, dob);
			ps.setString(6, gender);
			ps.setDouble(7, fees);
			
			res = ps.executeUpdate();
			
			con.close();
			
		}catch(ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch(SQLException ex) {		
			System.out.println(ex.getMessage());		
		}
		return res;
	}
}
