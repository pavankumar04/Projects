package com.jpa.demo.HibernateJpaCrudDemo.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.jpa.demo.HibernateJpaCrudDemo.entity.Doctor;
import com.jpa.demo.HibernateJpaCrudDemo.util.JPAUtil;

public class CrudOperations {
	public void saveEntity(String fname, String lname, String sp) {
		EntityManager em = JPAUtil.buildEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Doctor doctor = new Doctor(fname, lname, sp);
		em.persist(doctor);
		
		et.commit();
		em.close();
	}
	
	public void findEntity(int id) {
		EntityManager em = JPAUtil.buildEntityManagerFactory().createEntityManager();
				
		Doctor doctor = em.find(Doctor.class, id);
		
		System.out.println(doctor.toString());
		em.close();
	}
	
	public void findAllEntities() {
		EntityManager em = JPAUtil.buildEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Doctor", Doctor.class);
		@SuppressWarnings("unchecked")
		List<Doctor> doctors = query.getResultList();
		
		doctors.forEach(d -> System.out.println(d.toString()));
	}
	
	public void updateEntity(int id, String sp) {
		EntityManager em = JPAUtil.buildEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("UPDATE Doctor d SET d.specialization = :special WHERE d.doctorId = :doc");
		query.setParameter("special", sp);
		query.setParameter("doc", id);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		int result = query.executeUpdate();
		System.out.println("Rows Updated: " + result);
		
		et.commit();
		em.close();
		
	}
	
	public void removeEntity(int id) {
		EntityManager em = JPAUtil.buildEntityManagerFactory().createEntityManager();
		
		Doctor doctor = em.find(Doctor.class, id);
		if(doctor != null) {
			System.out.println(doctor.toString());
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			System.out.println("Deleting Doctor with id: " + id);
			
			em.remove(doctor);
			et.commit();
		}
		
		em.close();
		
	}
}
