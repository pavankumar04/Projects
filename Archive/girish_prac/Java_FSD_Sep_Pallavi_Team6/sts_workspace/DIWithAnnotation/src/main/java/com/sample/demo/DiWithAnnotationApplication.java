package com.sample.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sample.demo.model.AppConfig;
import com.sample.demo.model.Department;

public class DiWithAnnotationApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Department d = context.getBean(Department.class);
		d.showDetails();
		
		context.close();
	}

}
