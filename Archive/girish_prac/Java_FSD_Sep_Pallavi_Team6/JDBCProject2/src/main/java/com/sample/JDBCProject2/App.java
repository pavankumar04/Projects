package com.sample.JDBCProject2;

import java.time.LocalDate;
import java.util.Scanner;

import com.sample.JDBCProject2.factory.ActorFactory;
import com.sample.JDBCProject2.model.Actor;

/**
 * Main Class
 *
 */
public class App 
{
	Scanner sc = new Scanner(System.in);
	private void mainMenu(){
		System.out.println("----------Menu----------");
		System.out.println("1. View All Actors");;
		System.out.println("2. View All Actors");;
		System.out.println("3. Add New Actor");;
		System.out.println("4. Update Actor Details");;
		System.out.println("5. Delete Actor");
		System.out.println("6. Exit");
		System.out.println("Enter Your Choice: ");
		int ch = sc.nextInt();
		
		switch (ch) {
		case 1:
			Actor[] actors = ActorFactory.retrieveAll();
			
			if(actors.length > 0) {
				for(Actor a: actors) {
					System.out.println(a.toString());
				}
			}else {
				System.out.println("No Actors");
			}
			break;
		case 2:
			System.out.println("Enter the Id: ");
			int id = sc.nextInt();
			
			Actor actor = ActorFactory.findById(id);
			if(actor.getActorId() > 0) {
				System.out.println(actor.toString());
			}else {
				System.out.println("Actor Not Found");
			}
			break;
		case 3:
			String str = getActorInfo();
				System.out.println(str);
			break;
		case 4:
			System.out.println("getting developed");
			break;
		case 6:
			System.exit(0);
		default:
			break;
		}
		mainMenu();
	}
	
	private String getActorInfo() {
		System.out.println("Enter First Name: ");
		String fName = sc.next();
		System.out.println("Enter Last Name: ");
		String lName = sc.next();
		System.out.println("Enter Phone: ");
		String ph = sc.next();
		System.out.println("Enter Gender (Male/Female): ");
		String gen = sc.next();
		
		gen = gen.toUpperCase();
		
		System.out.println("Enter date of birth (yyyy-mm-dd): ");
		String d= sc.next();
		LocalDate Id = LocalDate.parse(d);
		
		System.out.println("Enter the payment Amount: ");
		double rate = sc.nextDouble();
		
		Actor a = new Actor();
		String msg = a.addNewActor(fName, lName, ph, rate, Id, gen);
		return msg;
	}
	
    public static void main( String[] args )
    {
        App obj = new App();
        obj.mainMenu();
    }
}
