package com.sample.demo.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.sample.demo.model")
public class AppConfig {
	
	@Bean
	public Employee getEmployee() {
		return new EmployeeImpl();
	}
}
