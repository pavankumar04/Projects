package com.jpa.demo.HibernateAssociationsDemo;

import java.util.ArrayList;
import java.util.List;

import com.jpa.demo.HibernateAssociationsDemo.dao.CourseDao;
import com.jpa.demo.HibernateAssociationsDemo.dao.TrainerDao;
import com.jpa.demo.HibernateAssociationsDemo.entity.Course;
import com.jpa.demo.HibernateAssociationsDemo.entity.Trainer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Course course = new Course("Learn Java", 23000.00);
        
        CourseDao cDao = new CourseDao();
        cDao.saveCourseDetails(course);
        
        Trainer trainer = new Trainer();
        trainer.setFirstName("Prakash");
        trainer.setLastName("Mane");
        trainer.setEmail("prakash.mane@gmail.com");
        
        List<Course> courses = new ArrayList<Course>();
        courses.add(course);
        
        trainer.setCourses(courses);
        
        TrainerDao tDao = new TrainerDao();
        
        tDao.saveTrainerDetails(trainer);
    }
}
