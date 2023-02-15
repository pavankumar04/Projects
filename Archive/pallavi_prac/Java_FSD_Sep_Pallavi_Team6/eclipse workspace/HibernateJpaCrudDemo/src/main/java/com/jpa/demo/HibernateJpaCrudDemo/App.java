package com.jpa.demo.HibernateJpaCrudDemo;

import java.util.Scanner;

import com.jpa.demo.HibernateJpaCrudDemo.crud.CrudOperations;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
        CrudOperations op = new CrudOperations();
        
        System.out.print("Enter Doctor id:");
        int id = sc.nextInt();
//        System.out.print("Enter First Name: ");
//        String fname = sc.next();
//        
//        System.out.print("Enter Last Name: ");
//        String lname = sc.next();
//        
//        System.out.print("Enter Specialization: ");
//        String sp = sc.next();
//        
//        op.saveEntity(fname, lname, sp);
//        op.findEntity(1);
//        op.findAllEntities();
        
//        op.updateEntity(id, sp);
        op.removeEntity(id);
        sc.close();
    }
}
