package com.sample.hibernate.HibernateJpaDemo.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.sample.hibernate.HibernateJpaDemo.entity.Student;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration config = new Configuration();
			
			Properties props = new Properties();
			
			props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			props.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_demo?useSSL=false");
			props.put(Environment.USER, "root");
			props.put(Environment.PASS, "Pass1234");
			props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
			props.put(Environment.SHOW_SQL, "true");
			props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			props.put(Environment.HBM2DDL_AUTO, "update");
			
			config.setProperties(props);
			
			config.addAnnotatedClass(Student.class);
			
			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			sessionFactory = config.buildSessionFactory(registry);
		}
		
		return sessionFactory;
	}
}
