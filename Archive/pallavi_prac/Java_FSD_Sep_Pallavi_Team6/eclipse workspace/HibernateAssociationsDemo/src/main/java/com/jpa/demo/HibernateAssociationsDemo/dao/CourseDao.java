package com.jpa.demo.HibernateAssociationsDemo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpa.demo.HibernateAssociationsDemo.entity.Course;
import com.jpa.demo.HibernateAssociationsDemo.util.JPAUtil;

public class CourseDao {
	public void saveCourseDetails(Course course) {
		EntityManager em = JPAUtil.buildEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		em.persist(course);
		et.commit();
		em.close();
	}
}
