package com.sample.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sample.demo.data.Employee;
import com.sample.demo.data.EmployeeImpl;

@Configuration
@ComponentScan(basePackages="com.sample.demo.data")
public class AppConfig {
	
	@Bean
	public Employee getEmployee() {
		return new EmployeeImpl();
	}
}
