package com.sample.demo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sample.demo.model.Account;
import com.sample.demo.model.Admin;
import com.sample.demo.model.Recepient;
import com.sample.demo.model.Transactions;
import com.sample.demo.model.Users;
import com.sample.demo.repository.AccountRepository;
import com.sample.demo.repository.AdminRepository;
import com.sample.demo.repository.RecepientRepository;
import com.sample.demo.repository.TransactionsRepository;
import com.sample.demo.repository.UserRepository;

@SpringBootApplication
public class BankingManagementSystemApplication {
	private static void mainMenu(UserRepository ur, AdminRepository ar, AccountRepository acr, TransactionsRepository tr,
			RecepientRepository rr) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); 
		System.out.println("-#-#-#-#-WELCOME TO HEXA BANK Ltd-#-#-#-#-");
		System.out.println(".,.,.,.,.,.LIFE KA BHAROSA.,.,.,.,.,.");
		System.out.println("1. Login as @Admin");
		System.out.println("2. Login as $User");
		System.out.println("3. Register for User");
		System.out.println("4. Exit");
		System.out.println(" Choose your response ");
		int ch = sc.nextInt();
		switch(ch){
		case 1:
			System.out.println("Enter Admin Id");
			int id = sc.nextInt();
			System.out.println("Enter Admin Password");
			String pa = sc.next();
			Admin adm = ar.findById(id);
			if (adm.getAdminPassword().equals(pa)) {
				System.out.println("@@@--------WELCOME ADMIN--------@@@");
				adminMenu(ar,acr,ur,tr,rr);
			}else {
			System.out.println("AdminId or password incorrect");
			}
			mainMenu(ur,ar,acr,tr,rr);
			break;
		case 2:
			System.out.println("Enter User Email");
			String em = sc.next();
			System.out.println("Enter Password");
			String pas = sc.next();
			Account ac = acr.findByEmail(em);
			if (ac.getPassword().equals(pas)) {
				System.out.println("$$$$$$$---WELCOME USER---$$$$$$$");
				userMenu(ur,acr,tr,rr);
			}else {
			System.out.println("Password or username isnot correct");
			System.out.println("please try again");
			
			}
			mainMenu(ur,ar,acr,tr,rr);
			break;
		case 3:
			System.out.print("Enter First Name: ");
            String fn = sc.next();
            System.out.print("Enter Last Name: ");
            String ln = sc.next();
            System.out.print("Enter Email: ");
            String ema = sc.next();
            System.out.print("Enter Phone Number: ");
            int ph = sc.nextInt();
            System.out.print("Enter Pan Number: ");
            int pan = sc.nextInt();
            System.out.print("Enter Aadhar Number: ");
            int re = sc.nextInt();
            System.out.print("Enter Address: ");
            String adr = sc.next();
            System.out.print("Enter City: ");
            String ci = sc.next();
            
            Users user = new Users(fn, ln, ema, ph, pan, re, adr, ci);
            int res = ur.register(user);
            if (res > 0) {
            	System.out.println(" User registered Successfully");
            } else {
            	System.out.println("Unable to Register the user");
            	System.out.println("please try again");	
            }
            mainMenu(ur,ar,acr,tr,rr);
            break;
		case 4:
			sc.close();
			Runtime.getRuntime().exit(0);
		default:
				break;
		}
		mainMenu(ur, ar, acr, tr, rr);					
		}
	
	private static void adminMenu(AdminRepository ar, AccountRepository acr, UserRepository ur, TransactionsRepository tr, RecepientRepository rr) {
		    Scanner sc = new Scanner(System.in);		 
	        System.out.println("1. Add New User ");
	        System.out.println("2. Update Admin Password ");
	        System.out.println("3. Update Account Type");
	        System.out.println("4. Get All User Info ");
	        System.out.println("5. Add New Account ");
	        System.out.println("6. Perform Transaction");
	        System.out.println("7. View All Transactions");
	        System.out.println("8. View Transactions By status");
	        System.out.println("9. Exit ");
	        System.out.print("Enter Your choice? ");
	        int op = sc.nextInt();
	        switch(op) {
	        case 1:
	        	System.out.print("Enter First Name: ");
	            String fn = sc.next();
	            System.out.print("Enter Last Name: ");
	            String ln = sc.next();
	            System.out.print("Enter Email: ");
	            String ema = sc.next();
	            System.out.print("Enter Phone Number: ");
	            int ph = sc.nextInt();
	            System.out.print("Enter Pan Number: ");
	            int pan = sc.nextInt();
	            System.out.print("Enter Aadhar Number: ");
	            int re = sc.nextInt();
	            System.out.print("Enter Address: ");
	            String adr = sc.next();
	            System.out.print("Enter City: ");
	            String ci = sc.next();
	            
	            Users user = new Users(fn, ln, ema, ph, pan, re, adr, ci);
	            int res = ur.register(user);
	            if (res > 0) {
	            	System.out.println("New user added to the database");
	            } else {
	            	System.out.println("Unable to Add User ");
	            }
	            adminMenu(ar,acr,ur,tr,rr);
	        	break;
	        case 2:
	        	System.out.println("Enter the Admin ID: ");
	            int pnu = sc.nextInt();
	            
	            System.out.print("Enter New Password : ");
	            String pn = sc.next();
	            
	            Admin u = new Admin(pnu, null, null ,pn);
	            int res4 = ar.updatePassword(u);
	            if(res4 > 0) {
	                System.out.println("Password Updated");
	            } else {
	                System.out.println("Unable to update Paasword");
	            }
	            adminMenu(ar,acr,ur,tr,rr);
	        	break;
	        case 3:
	        	System.out.println("Enter the Account Number: ");
	            int pnuh = sc.nextInt();
	            
	            System.out.print("Enter New Account Type : ");
	            String pni = sc.next();
	            
	            Account au = new Account(pnuh, null, null ,pni, 0);
	            int res3 = acr.updateRole(au);
	            if(res3 > 0) {
	                System.out.println("Account Type Updated");
	            } else {
	                System.out.println("Unable to update Account Type");
	            }
	            adminMenu(ar,acr,ur,tr,rr);
	        	break;
	        case 4:
	        	List<Users> list = ur.retrieveAllUsers();
	        	if (list.size() > 0) {
	                for(Users p: list) {
	                    System.out.println(p.toString());
	                }
	            } else {
	                System.out.println("Unable to retrieve Users list");
	            }
	        	adminMenu(ar,acr,ur,tr,rr);
	        	break;	
	        case 5:
	        	System.out.print("Enter Email: ");
	            String e2 = sc.next();
	            System.out.print("Enter Password: ");	           
	                String desc = sc.next();
	                System.out.print("Enter Role: ");
	                String r1 = sc.next();
	                System.out.print("Enter Balance: ");
	                double b1 = sc.nextDouble();
	                Account acc1 = new Account(0, e2, desc, r1, b1);
	                int ress = acr.addAccount(acc1);
	                if(ress > 0) {
	                    System.out.println("Account Added");
	                } else {
	                    System.out.println("Unable to add Account");
	                }
	                adminMenu(ar,acr,ur,tr,rr);
    	          	        	
	        	break;
	        case 6:
	        	System.out.println("Enter amount to be transfered");
				double amt=sc.nextDouble();				
				System.out.println("Enter account number");
				int ac2=sc.nextInt();
				
				Account acc2=acr.findByAccNumber(ac2);
				if(acc2!=null)
				{
					double bal2=acc2.getBalance();
					if(amt<bal2)
					{
						System.out.println("Enter recepient ac number");
						int rac=sc.nextInt();
						Recepient rec=rr.findByAccNumber(rac);
						if(rec!=null) {
							double b = acc2.getBalance();
							double d = b-amt;
							int au1=acr.updateBalance(d,acc2);
							if(au1>0) {
								System.out.println("Amount transfered successfully");
								String stat = "Success";								
								LocalDate date = LocalDate.now();
								Transactions tr1=new Transactions(0,ac2,"debit",stat,rac,date);
								int t1=tr.addNewTrans(tr1);
								if(t1>0)
								{
									System.out.println("Transcation successful");
								}else {
									String stat2 = "failed";
									Transactions tr2=new Transactions(0,ac2,"debit",stat2,rac,date);
									int t2 = tr.addNewTrans(tr2);
									if(t2>0) {
									System.out.println("Unsuccessful transcation");
									}
								}
							}else {
								System.out.println("Amount cannot be transfered");
							}
						}else {
							System.out.println("Recepient ac Number not found");
						}
					}else {
						System.out.println("Not enough balance");
					}
				}
				adminMenu(ar,acr,ur,tr,rr);       	
	        	break;
	        case 7:
	        	List<Transactions> list3=tr.viewAllTransaction();
				if(list3!=null) {
					for(Transactions t:list3)
					{
						System.out.println(t.toString());
					}
				}else {
					System.out.println("Unable to find Transactions ");
				}
				adminMenu(ar,acr,ur,tr,rr);
	        	break;
	        case 8:
	        	System.out.println("enter the status");
	        	String stt=sc.next();
	        	List<Transactions> list4=tr.viewTransByStatus(stt);
	        	if (list4.size()>0) {
	        		for(Transactions t:list4)
					{
						System.out.println(t.toString());
					}
				}else {
					System.out.println("Unable to find Transactions ");
				}
	        	adminMenu(ar,acr,ur,tr,rr);
	        	break;	        
	        case 9:
	        	sc.close();
				Runtime.getRuntime().exit(0);
			default:
				mainMenu(ur,ar,acr,tr,rr);
	        	break;
	        	
	        }
	}
    private static void userMenu(UserRepository ur, AccountRepository acr, TransactionsRepository tr, RecepientRepository rr) {
    	Scanner sc = new Scanner(System.in);
        System.out.println("1. View Account Balance ");
        System.out.println("2. Do Transaction ");
        System.out.println("3. Update User Phone Number");
        System.out.println("4. Update User Email ");
        System.out.println("5. View Transaction History ");        
        System.out.println("6. Exit ");
        System.out.print("Enter Your choice? ");
        int op = sc.nextInt();
        
        switch(op) {
        case 1:
        	System.out.println("Enter Account Number");
        	int accNo = sc.nextInt();
        	Account acc = acr.showBalance(accNo);
        	double bal = acc.getBalance();
        	System.out.println("Current Balance is :"+ bal);
        	System.out.println();
        	userMenu(ur,acr,tr,rr);
        	break;
        case 2:
        	System.out.println("Enter amount to be transfered");
			double amt=sc.nextDouble();			
			System.out.println("Enter account number");
			int ac2=sc.nextInt();
			
			Account acc2=acr.findByAccNumber(ac2);
			if(acc2!=null)
			{
				double bal2=acc2.getBalance();
				if(amt<bal2)
				{
					System.out.println("Enter recepient ac number");
					int rac=sc.nextInt();
					Recepient rec=rr.findByAccNumber(rac);
					if(rec!=null) {
						double b = acc2.getBalance();
						double c = b-amt;
						int au=acr.updateBalance(c,acc2);
						
						if(au>0) {
							System.out.println("Amount transfered successfully");
							String stat = "Success";
							
							LocalDate date = LocalDate.now();
							Transactions tr1=new Transactions(0,ac2,"debit",stat,rac,date);
							int t1=tr.addNewTrans(tr1);
							if(t1>0)
							{
								System.out.println("Transcation successful");
							}else {
								String stat2 = "failed";
								Transactions tr2=new Transactions(0,ac2,"debit",stat2,rac,date);
								int t2 = tr.addNewTrans(tr2);
								System.out.println("Unsuccessful transcation");
							}
						}else {
							System.out.println("Amount cannot be transfered");
						}
					}else {
						System.out.println("Recepient ac Number not found");
					}
				}else {
					System.out.println("Not enough balance");
				}
			}
			
			userMenu(ur,acr,tr,rr);
        	
        	break;
        case 3:
            System.out.println("Enter the Pan Number: ");
            int pnu = sc.nextInt();
            
            System.out.print("Enter New Phone Number: ");
            int pn = sc.nextInt();
            
            Users u = new Users(null, null, null ,pn, pnu, 0, null, null);
            int res = ur.updatePhoneNumber(u);
            if(res > 0) {
                System.out.println("Phone Number Updated");
            } else {
                System.out.println("Unable to update phone Number");
            }
            userMenu(ur,acr,tr,rr);
        	break;
        case 4:
        	System.out.println("Enter the Pan Number: ");
            int panu = sc.nextInt();
            
            System.out.print("Enter New Email: ");
            String emi = sc.next();
            
            Users u2 = new Users(null, null, emi ,0,panu, 0,null,null);
            int res1 = ur.updateEmail(u2);
            if(res1 > 0) {
                System.out.println("Email Updated");
            } else {
                System.out.println("Unable to update Email");
            }
            userMenu(ur,acr,tr,rr);
        	break;	
        case 5:        	
        	System.out.println("Enter the Account Number: ");
            int ac1 = sc.nextInt();                     
            List<Transactions> list = tr.viewTransByAccNo(ac1);
            if (list.size() > 0) {
                for(Transactions i: list) {
                    System.out.println(i.toString());
                }
            } else {
                System.out.println("Unable to retrieve Transactions.");
            }
            userMenu(ur,acr,tr,rr);
        	break;        
        case 6:
        	sc.close();
			Runtime.getRuntime().exit(0);
		default:
        	break;
        	
        }
		
	}
	
	
                 	
	public static void main(String[] args) {
		 ApplicationContext context =SpringApplication.run(BankingManagementSystemApplication.class, args);
		
		 UserRepository ur = context.getBean(UserRepository.class);
		 AdminRepository ar = context.getBean(AdminRepository.class);
		 AccountRepository acr = context.getBean(AccountRepository.class);
		 TransactionsRepository tr = context.getBean(TransactionsRepository.class);
		 RecepientRepository rr = context.getBean(RecepientRepository.class);
		 mainMenu(ur,ar,acr,tr,rr);
		
		
	
}
}
	
	