package com.jpa.demo.HibernateAssociationsDemo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpa.demo.HibernateAssociationsDemo.entity.Trainer;
import com.jpa.demo.HibernateAssociationsDemo.util.JPAUtil;

public class TrainerDao {
	public void saveTrainerDetails(Trainer trainer) {
		EntityManager em = JPAUtil.buildEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		em.persist(trainer);
		et.commit();
		em.close();
	}
}
