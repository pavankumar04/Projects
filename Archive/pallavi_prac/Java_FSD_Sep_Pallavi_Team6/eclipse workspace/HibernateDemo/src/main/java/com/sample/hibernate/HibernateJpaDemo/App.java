package com.sample.hibernate.HibernateJpaDemo;

import java.util.List;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.Query;

import com.sample.hibernate.HibernateJpaDemo.dao.StudentDao;
import com.sample.hibernate.HibernateJpaDemo.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentDao dao = new StudentDao();
        
        Student s1 = new Student("Sanvi", "Suhas", "sanvi@gmail");
        
        dao.saveStudent(s1);
        
        List<Student> students = dao.getAllStudents();
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");
//        
//        EntityManager em = emf.createEntityManager();
//        Query q = em.createNamedQuery("selectQuery");
//        
//        @SuppressWarnings("unchecked")
//		List<Student> students = (List<Student>) q.getResultList();
        
        students.forEach(s -> System.out.println(s.toString()));
    }
}
