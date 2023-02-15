package com.sample.demo;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sample.demo.config.AppConfig;
import com.sample.demo.data.Department;

public class AnnotationsDiApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        Department dept = context.getBean(Department.class);
        dept.showEmployeeData();
        
        System.out.print("Enter your message (1 word): ");
        Scanner sc = new Scanner(System.in);
        String msg = sc.next();
        dept.printMessage(msg);
        
        sc.close();
        context.close();
    }

}