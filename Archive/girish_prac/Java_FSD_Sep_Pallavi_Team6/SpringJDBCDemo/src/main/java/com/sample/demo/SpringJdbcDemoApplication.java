package com.sample.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sample.demo.dao.IEmployeeDao;
import com.sample.demo.model.Employee;

import java.util.List;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringJdbcDemoApplication.class, args);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AppConfiguration.xml");
		IEmployeeDao employeeDao = context.getBean("employeeDao", IEmployeeDao.class);
		
		List<Employee> list = employeeDao.getAll();
		for(Employee emp: list) {
			System.out.println(emp.toString());
		}
	}

}
