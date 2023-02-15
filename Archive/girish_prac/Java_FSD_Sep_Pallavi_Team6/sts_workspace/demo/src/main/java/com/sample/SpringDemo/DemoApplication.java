package com.sample.SpringDemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
@SuppressWarnings("deprecation")
public class DemoApplication {

	public static void main(String[] args) {
		
//		Resource resource = new ClassPathResource("applicationContext.xml"); // part of Core module
//		BeanFactory factory = new XmlBeanFactory(resource); //part of Beans module
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Employee emp = (Employee)factory.getBean("e");  // part of SPeL module
		Employee emp = (Employee)context.getBean("e");
		emp.displayData();
		
//		Address addr = (Address)factory.getBean("a");
//		System.out.println(addr.toString());
//		SpringApplication.run(DemoApplication.class, args);
	}

}
