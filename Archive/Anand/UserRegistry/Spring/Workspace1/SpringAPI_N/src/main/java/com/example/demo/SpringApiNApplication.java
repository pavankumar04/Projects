package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {
	    DataSourceAutoConfiguration.class
	})
@ComponentScan ({"com.example.demo", "com.example.demo.service"})
public class SpringApiNApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiNApplication.class, args);
	}

}
