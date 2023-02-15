package com.sample.hibernate.HibernateJpaDemo.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sample.hibernate.HibernateJpaDemo.entity.Student;
import com.sample.hibernate.HibernateJpaDemo.util.HibernateUtil;

public class StudentDao {
	public void saveStudent(Student student) {
		Transaction trx = null;
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			trx = session.beginTransaction();
			
			Object obj = session.save(student);
			
			session.get(Student.class, (Serializable)obj);
			
			trx.commit();
		} catch (Exception e) {
			if(trx != null) {
				trx.rollback();
			}
			
			System.out.println(e.getMessage());
		}
	}
	
//	public void insertStudentData(Student student) {
//		Transaction trans = null;
//		
//		try {
//			Session session = HibernateUtil.getSessionFactory().openSession();
//			trans = session.beginTransaction();
//			
//			String sql = "INSERT INTO STUDENT (FIRSTNAME, LASTNAME, EMAIL) " 
//					+ "SELECT FIRSTNAME, LASTNAME, EMAIL FROM STUDENT";		
//			Query query = session.createQuery(sql);
//			
//			int res = query.executeUpdate();
//			System.out.println("Rows Affected: " + res);
//			
//			trans.commit();
//		} catch (Exception e) {
//			if(trans != null) {
//				trans.rollback();
//			}
//			
//			System.out.println(e.getMessage());
//		}
//	}
	
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			students = session.createQuery("from Student", Student.class).list();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return students;
	}
}
