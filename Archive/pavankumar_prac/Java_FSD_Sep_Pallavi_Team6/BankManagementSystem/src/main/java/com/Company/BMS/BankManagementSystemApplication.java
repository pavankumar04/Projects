package com.Company.BMS;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.Company.BMS.model.Account;
import com.Company.BMS.model.Admin;
import com.Company.BMS.model.Recepient;
import com.Company.BMS.model.Transaction;
import com.Company.BMS.model.User;
import com.Company.BMS.repository.AccountRepository;
import com.Company.BMS.repository.AdminRepository;
import com.Company.BMS.repository.AppointmentRepository;
import com.Company.BMS.repository.RecepientRepository;
import com.Company.BMS.repository.TransactionRepository;
import com.Company.BMS.repository.UserRepository;
import com.Company.BMS.util.AcctType;
import com.Company.BMS.util.BankType;
import com.Company.BMS.util.TxnType;

@SpringBootApplication
public class BankManagementSystemApplication {	
	private static void mainMenu(UserRepository ur, AdminRepository adr, AccountRepository acctr, AppointmentRepository apptr, RecepientRepository rcptr, TransactionRepository txnr) {
		Scanner sc = new Scanner(System.in); 		
		System.out.println("\n__________________________");
		System.out.println("1. Login as User");
		System.out.println("2. Register");
		System.out.println("3. Login as Admin");
		System.out.println("4. Exit\n");
		System.out.print("Enter your choice: ");
		int ch = sc.nextInt();
		sc.nextLine();
		System.out.println();
		switch(ch) {
		case 1:
			System.out.print("Username: ");
			String username = sc.nextLine();
			System.out.print("Password: ");
			String password = sc.nextLine();
			
			User user = ur.findByUsername(username);
			
			if(user == null) {
				System.out.println("\nPlease register to continue");
			}
			else if(user.getPassword().equals(password)) {
				System.out.println("\nLogin Successful");
				System.out.println("Welcome to Our Banking Network");
				
				
				List<Account> acctList = acctr.viewAllAccountsOfUser(user.getUserId());
				Account acct = null;
				
				if(acctList.size() > 1) {
					System.out.println("Continue with ");
				    int index = 0;
					for(Account i : acctList) {
						index++;
						System.out.println(index+". "+i.getAcctType()+" : "+i.getAcctNo());				
					}
					System.out.print("Your Choice ?  : ");
					int c = sc.nextInt();				
					acct = acctList.get(c-1);
					
				}
				else {
					acct = acctList.get(0);
				}
				
				userMenu(ur, acctr, txnr, apptr, rcptr, user, acct);
			}
			else {
				System.out.println("Username or Password mismatch \n");
				
			}
			break;
			
		case 2:
			System.out.print("\nFirst Name : ");
			
			String fn = sc.nextLine();
			
			System.out.print("Last Name : ");
			String ln = sc.nextLine();
			
			System.out.print("Email: ");
			String em = sc.nextLine();
			
			System.out.print("PhoneNo : ");
			String phno = sc.nextLine();
			
			System.out.print("PAN Number : ");
			String pan = sc.nextLine();
			
			
			System.out.print("date of birth : ");
			String birthdate = sc.nextLine();
			LocalDate dob = LocalDate.parse(birthdate);
			
			
			System.out.print("AadharNo : ");
			String aadhar = sc.nextLine();
			
			
			System.out.print("Address : ");
			String addr = sc.nextLine();
			
			
			System.out.print("city : ");
			String city = sc.nextLine();
			
			System.out.print("Username : ");
			String un = sc.nextLine();
			
			System.out.print("Password : ");
			String pass = sc.nextLine();
			System.out.print("Confirm Password : ");
			String re = sc.nextLine();
			
					
			if (pass.equals(re)) {
				User u1 = new User(0,fn, ln,un,pass, em, phno, pan, dob, aadhar, addr, city );
				int res = ur.add(u1);
				
				if (res > 0) {
					System.out.println("User Registered");
					System.out.println("Please login to continue\n");
				} else {
					System.out.println("Unable to register\n");
				}
			} else {
				System.out.println("Password mismatch\n");
			}
			break;
			
		case 3:
			System.out.print("\nEnter Email: ");
			String adEmail = sc.nextLine();
			System.out.print("Enter Password: ");
			String adPass = sc.nextLine();
			
			Admin admin = adr.findByEmail(adEmail);
			
			if(admin == null) {
				System.out.println("Username is incorrect \n");
			}
			else if(admin.getPassword().equals(adPass)) {
				System.out.println("Login Successfull \n");
				adminMenu(ur, adr, acctr, txnr, apptr, admin );
			}
			else {
				System.out.println("Username or Password mismatch \n");
				System.out.println(admin.toString());
			}
			
			break;
		case 4:
			sc.close();
			Runtime.getRuntime().exit(0);
		default:
			break;
			
	}
	mainMenu(ur, adr, acctr, apptr, rcptr, txnr);
}
	
	
	
	
	
	private static void userMenu(UserRepository ur, AccountRepository acctr, TransactionRepository txnr, AppointmentRepository apptr, RecepientRepository rcptr, User user, Account acct) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n__________________________");
		System.out.println("1. Show my details");
		System.out.println("2. update Password");
		System.out.println("3. check account balance");
		System.out.println("4. Transfer amount");
		System.out.println("5. Add Money");
		System.out.println("6. View Transaction History");
		System.out.println("7. Add a new recepient ");
		System.out.println("8. View all recepients ");
		System.out.println("9. Delete a recepient : ");
		System.out.println("10. update recepient account number : ");
		System.out.println("11. exit\n");
		
		System.out.print("Your choice? ");
		int op = sc.nextInt();
		System.out.println();
		
		switch(op) {
		case 1:
			System.out.println(user.toString());
			break;
		case 2:
			System.out.print("\nEnter the new password : ");
			String pass1 = sc.next();
			System.out.print("confirm password : ");
			String pass2 = sc.next();
			
			if(pass1.equals(pass2)) {
				ur.updatePassword(user,pass2);
				System.out.println("Password updated successfully");
			}
			else {
				System.out.println("Entered different passwords. Please try again");
			}
			
		case 3:
			System.out.println("\nBalance is : "+  acctr.viewBalance(acct.getAcctNo()));
			break;
			
		case 4:		
			System.out.println("\nBalance is : "+acctr.viewBalance(acct.getAcctNo()));
			System.out.print("Enter recepient account number : ");
			long toAcct = sc.nextLong();
			sc.nextLine();
			
			System.out.print("Amount to send : ");
			double amt = sc.nextDouble();
			sc.nextLine();
			
			double bal = acctr.viewBalance(acct.getAcctNo());
			
			if(bal >= amt) {
				Transaction txn = new Transaction(0, acct.getAcctNo(), toAcct, LocalDate.now(), TxnType.valueOf("WITHDRAWL"), amt,bal-amt);
				int res1 = acctr.updateBalance(acct, bal-amt);
				int res2 = txnr.add(txn);
				
				if(res1 > 0 && res2 > 0) {
					System.out.println("Successfully transfered funds");
					System.out.println("Remaining Balance is : "+acctr.viewBalance(acct.getAcctNo())+"\n");
				}
				else {
					System.out.println("Unable to transfer funds. PLaese try again\n");
				}
				
				
			}
			else {
				System.out.println("Not enough balamce\n");
			}
			break;
		case 5:
			System.out.print("Enter the amount to deposit : ");
			double amt1 = sc.nextDouble();
			sc.nextLine();
			
			int r = acctr.updateBalance(acct, acctr.viewBalance(acct.getAcctNo())+amt1);
			if(r > 0) {
				System.out.println("amount credited Successfully ");
			}
			else {
				System.out.println("amount not credited Please try again ");
			}
			break;
		case 6:
			System.out.println("\nTransaction history for the accouunt "+ acct.getAcctNo());
			List<Transaction> txnList = txnr.viewAllTxns(acct);
			for(Transaction i : txnList) {
				System.out.println(i.toString());
			}
			
			break;
			
		case 7:
			System.out.print("Enter account number : ");
		    Long rac = sc.nextLong();
		    sc.nextLine();
		    System.out.print("Enter recepient name : ");
		    String rname = sc.nextLine();
		    
		    System.out.print("Enter phone number : ");
		    String rphno = sc.nextLine();
		    
		    System.out.print("Bank Type (SAME / DIFFERENT) : ");
		    String rbank = sc.nextLine();
		    
			Recepient recpt = new Recepient(0, rac, rname, rphno, BankType.valueOf(rbank.toUpperCase()) );
			int res = rcptr.add(recpt);
			
			if(res > 0) {
				System.out.println("Successfully added recepient");
			}
			else {
				System.out.println("Failed to add recepient. Please Try again");
			}
			break;
		case 8:
			List<Recepient> rList = rcptr.viewAllRecepients();
			System.out.println("\n");
			for(Recepient i : rList) {
				System.out.println(i.toString());
			}
			break;
			
		case 9:
			System.out.println("Enter Recepient Id to delete : ");
			int rid = sc.nextInt();
			sc.nextLine();
			
			int res1 = rcptr.deleteById(rid);
		    if(res1 > 0) {
		    	System.out.println("Successfully deleted");
		    }
		    else {
		    	System.out.println("Unable to delete. try after some time");
		    }
		    break;
		case 10:
			System.out.println("Enter recepient id : ");
			int rid2 = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter updated acccount number : ");
			long newNo = sc.nextLong();
			sc.nextLine();
			
			Recepient recpt1 = rcptr.findById(rid2);
			
			int res2 = rcptr.updateAccountNo(recpt1, newNo);
			
			if(res2 > 0) {
				System.out.println("Sucessfully updated");
			}
			else {
				System.out.println("NOt updated. Try after some time");
			}
			
			
		  
		    
		case 11:
			sc.close();
			Runtime.getRuntime().exit(0);
		default:
			break;
		}
		userMenu(ur, acctr, txnr, apptr, rcptr, user, acct );
	}
	
	
	
	
	private static void adminMenu(UserRepository ur, AdminRepository adr, AccountRepository acctr, TransactionRepository txnr, AppointmentRepository apptr, Admin admin) {
	Scanner sc = new Scanner(System.in);
	System.out.println("\n__________________________");
	System.out.println("1. Add a new user");
	System.out.println("2. View all user details");
	System.out.println("3. Add new account for a user");
	System.out.println("4. View all accoiunts of a user");
	System.out.println("5. change user password");
	System.out.println("6. change admin password");
	
	System.out.println("10. Exit");
	
	System.out.print("Your choice? ");
	int ch = sc.nextInt();
	sc.nextLine();
	int res = 0;
	
	switch (ch) {
	case 1:
		System.out.print("\nFirst Name : ");
		
		String fn = sc.nextLine();
		
		System.out.print("Last Name : ");
		String ln = sc.nextLine();
		
		System.out.print("Email: ");
		String em = sc.nextLine();
		
		System.out.print("PhoneNo : ");
		String phno = sc.nextLine();
		
		System.out.print("PAN Number : ");
		String pan = sc.nextLine();
		
		
		System.out.print("date of birth : ");
		String birthdate = sc.nextLine();
		LocalDate dob = LocalDate.parse(birthdate);
		
		
		System.out.print("AadharNo : ");
		String aadhar = sc.nextLine();
		
		
		System.out.print("Address : ");
		String addr = sc.nextLine();
		
		
		System.out.print("city : ");
		String city = sc.nextLine();
		
		System.out.print("Username : ");
		String un = sc.nextLine();
		
		System.out.print("Password : ");
		String pass = sc.nextLine();
		System.out.print("Confirm Password : ");
		String re = sc.nextLine();
		
				
		if (pass.equals(re)) {
			User u1 = new User(0,fn, ln,un,pass, em, phno, pan, dob, aadhar, addr, city );
			res = ur.add(u1);
			
			if (res > 0) {
				System.out.println("User Registered");
				System.out.println("Please login to continue");
			} else {
				System.out.println("Unable to register");
			}
		} else {
			System.out.println("Password mismatch");
		}
		break;
		
	case 2:
		List<User> userList = adr.viewAllUsers();
		System.out.println("\n");
		for(User i: userList) {
			System.out.println(i.toString());
		}
		break;
		
	case 3:
		System.out.print("\nEnter new Account number : ");
		long newAcc = sc.nextLong();
		sc.nextLine();
		
		System.out.print("Account type (SAVINGS / CURRENT/ SALARY) : ");
		String type = sc.nextLine();
		
		System.out.print("Enter userId : ");
		int uid = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter initial balance : ");
		double bal = sc.nextDouble();
		sc.nextLine();
		
		Account acct = new Account(newAcc, AcctType.valueOf(type.toUpperCase()) , uid, bal);
		res = acctr.add(acct);
		
		if(res > 0) {
			System.out.println("Added account");
		}
		else {
			System.out.println("unable to add account");
		}
		break;
		
	case 4:
		System.out.print("\nEnter username : ");
	    String uname = sc.nextLine();
		
		User user = ur.findByUsername(uname);
		
		List<Account> accList = acctr.viewAllAccountsOfUser(user.getUserId());
		
		for(Account i : accList) {
			System.out.println(i.toString());
		}
		break;
	case 5:
		System.out.println("Enter username : ");
		String un1 = sc.nextLine();
		
		System.out.println("Enter new password : ");
		String pass1 = sc.nextLine();
		
		User us = ur.findByUsername(un1);
		res = ur.updatePassword(us, pass1);
		
		if(res > 0) {
			System.out.println("Successfully changed password");
		}
		else {
			System.out.println("unable to change password");
		}
	break;
	case 6:
		System.out.println("Enter new password : ");
		String pass2 = sc.nextLine();
		
		System.out.println("Confirm new password : ");
		String repass = sc.nextLine();
		
		if(pass2.equals(repass)) {
			res = adr.updatePassword(admin, repass);
			if(res > 0) {
				System.out.println("Successfully changed password");
			}
			else {
				System.out.println("Unable to change password");				
			}
		}else {
			System.out.println("Password is not same");
		}
	break;

	case 10:
		sc.close();
		Runtime.getRuntime().exit(0);
	default:
		break;
	}
	adminMenu(ur, adr, acctr, txnr, apptr, admin);
}
	
	
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BankManagementSystemApplication.class, args);
		
		UserRepository ur = context.getBean(UserRepository.class);
		AdminRepository adr = context.getBean(AdminRepository.class);
		AccountRepository acctr = context.getBean(AccountRepository.class);
		AppointmentRepository apptr = context.getBean(AppointmentRepository.class);
		RecepientRepository rcptr = context.getBean(RecepientRepository.class);
		TransactionRepository txnr = context.getBean(TransactionRepository.class);
		
		mainMenu(ur,adr, acctr, apptr, rcptr, txnr);
		
		
		
		
		
		
	
		
		
	}

}
