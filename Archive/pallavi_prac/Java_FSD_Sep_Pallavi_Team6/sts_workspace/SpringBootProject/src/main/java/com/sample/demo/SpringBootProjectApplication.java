package com.sample.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sample.demo.model.Invoice;
import com.sample.demo.model.Products;
import com.sample.demo.model.Users;
import com.sample.demo.repository.InvoiceRepository;
import com.sample.demo.repository.ProductRepository;
import com.sample.demo.repository.UserRepository;

@SpringBootApplication
public class SpringBootProjectApplication {
	private static void mainMenu(UserRepository ur, ProductRepository pr, InvoiceRepository repo) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("1. Login as User");
		System.out.println("2. Register");
		System.out.println("3. Login as Admin");
		System.out.println("4. Exit");
		System.out.print("Enter your choice: ");
		int ch = sc.nextInt();
		
		switch(ch) {
		case 1:
			System.out.print("Username/ Email: ");
			String u = sc.next();
			System.out.print("Password: ");
			String p = sc.next();
			
			Users user = ur.findByEmail(u);
			if(user != null && user.getUserType().equals("user")) {
				if (user.getPasscode().equals(p)) {
					System.out.println("Welcome to Our Shopping Network");
					userMenu(ur, pr, user, repo);
				} else {
					System.out.println("Username or Password mismatch");
				}
			} else {
				System.out.println("Please register to continue");
			}
			break;
		case 2:
			System.out.print("First Name: ");
			String fn = sc.next();
			System.out.print("Last Name: ");
			String ln = sc.next();
			System.out.print("Email: ");
			String em = sc.next();
			System.out.print("Password: ");
			String pass = sc.next();
			System.out.print("Confirm pass: ");
			String re = sc.next();
			
			if (pass.equals(re)) {
				Users u1 = new Users(0, fn, ln, em, pass, "user");
				int res = ur.save(u1);
				
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
		case 3:
			System.out.print("Username/ Email: ");
			String ad = sc.next();
			System.out.print("Password: ");
			String pa = sc.next();
			
			Users user1 = ur.findByEmail(ad);
			if(user1.getUserType().equals("admin")) {
				if (user1.getPasscode().equals(pa)) {
					System.out.println("Welcome Admin");
					adminMenu(ur, pr, user1, repo);
				} else {
					System.out.println("Username or Password mismatch");
				}
			} else {
				System.out.println("Please login as User");
			}
			break;
		case 4:
			sc.close();
			Runtime.getRuntime().exit(0);
		default:
			break;
			
		}
		mainMenu(ur, pr, repo);
	}
	
	private static void userMenu(UserRepository ur, ProductRepository pr, Users u,
			InvoiceRepository repo) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. View All Products");
		System.out.println("2. View Product Details");
		System.out.println("3. Purchase Product");
		System.out.println("4. View Past Purchases");
		System.out.println("5. Update Password");
		System.out.println("6. View Current Purchases");
		System.out.println("7. Exit");
		System.out.print("Your choice? ");
		int op = sc.nextInt();
		
		switch(op) {
		case 1:
			List<Products> list = pr.showAllProducts();
			if (list.size() > 0) {
				for(Products p: list) {
					System.out.println(p.toString());
				}
			} else {
				System.out.println("Unable to retrieve products. Check with the Admin");
			}
			break; 
		case 2:
			System.out.println("Enter the product id: ");
			int id = sc.nextInt();
			Products product = pr.findById(id);
			if (product != null) {
				System.out.println(product.toString());
			}
			break;
		case 3:
			System.out.print("Enter the product Id: ");
			int pid = sc.nextInt();
			System.out.print("Enter the quantity: ");
			int qty = sc.nextInt();
			Products p =pr.findById(pid);
//			System.out.println(p.toString());
			if(p != null) {
				double amt = p.getPrice() * qty;
				LocalDate ld = LocalDate.now();
				Invoice inv = new Invoice(0, ld , qty, u.getUserId(), p.getProductId(), amt);
				//System.out.println(inv.toString());
				int res = repo.save(inv);
				
				if (res > 0) {
					System.out.println("Invoice Generated for your purchase.");
					System.out.println();
				} else {
					System.out.println("Unable to complete purchase. Please try later");
				}
			}
			break;
		case 4:
			List<Invoice> purchases = repo.listInvoicesForUser(u.getUserId());
			if(purchases.size() > 0) {
				for (Invoice i: purchases) {
					System.out.println(i.toString());
				}
			} else {
				System.out.println("No past purchases");
			}
			break;
		case 5:
			System.out.print("Enter new Password: ");
			String pass = sc.next();
			System.out.print("Confirm password: ");
			String confirm = sc.next();
			
			if(pass.equals(confirm)) {
				Users user = new Users(u.getUserId(), u.getFirstName(), u.getLastName(), u.getEmail(), pass, u.getUserType());
				int res = ur.updatePassword(user);
				
				if(res > 0) {
					System.out.println("Password updated");
				} else {
					System.out.println("Unable to update password");
				}
			} else {
				System.out.println("Password Mismatch");
			}
			break;
		case 6:
			List<Invoice> invoices = repo.listPurchasesForToday();
			if(invoices.size() > 0) {
				for (Invoice i: invoices) {
					System.out.println(i.toString());
				}
			} else {
				System.out.println("No purchases for today");
			}
			break;
		case 7:
			sc.close();
			Runtime.getRuntime().exit(0);
		default:
			break;
		}
		userMenu(ur, pr, u, repo);
	}
	
	private static void adminMenu(UserRepository ur, ProductRepository pr, Users u,
			InvoiceRepository repo) {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1. View All Products");
		System.out.println("2. View Product Details");
		System.out.println("3. Add New Product");
		System.out.println("4. Update Product Price");
		System.out.println("5. Remove Product");
		System.out.println("6. View All Purchases");
		System.out.println("7. View All Purchases By Product");
		System.out.println("8. View All Purchases By Date");
		System.out.println("9. View Current Purchase Details");
		System.out.println("10. Exit");
		System.out.print("Your choice? ");
		int ch = sc.nextInt();
		
		switch (ch) {
		case 1:
			List<Products> list = pr.showAllProducts();
			if (list.size() > 0) {
				for(Products p: list) {
					System.out.println(p.toString());
				}
			} else {
				System.out.println("Unable to retrieve products list");
			}
			break; 
		case 2:
			System.out.println("Enter the product id: ");
			int id = sc.nextInt();
			Products product = pr.findById(id);
			if (product != null) {
				System.out.println(product.toString());
			}
			break;
		case 3:
			System.out.print("Enter Product Name: ");
			String name = sc.next();
			System.out.print("Enter Description: ");
			try {
				String desc = br.readLine();
				System.out.print("Enter Brand: ");
				String brand = sc.next();
				System.out.print("Enter Price per unit: ");
				double price = sc.nextDouble();
				Products prod = new Products(0, name, desc, brand, price);
				int res = pr.save(prod);
				if(res > 0) {
					System.out.println("Product Added");
				} else {
					System.out.println("Unable to add product");
				}
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
			break;
		case 4:
			System.out.println("Enter the product id: ");
			int pId = sc.nextInt();
			
			System.out.print("Enter updated price: ");
			double rate = sc.nextDouble();
			
			Products p = new Products(pId, null, null, null, rate);
			int res = pr.update(p);
			if(res > 0) {
				System.out.println("Product Price Updated");
			} else {
				System.out.println("Unable to update product");
			}
			break;
		case 5:
			System.out.println("Enter the product id: ");
			int delId = sc.nextInt();
			int r = pr.deleteById(delId);
			
			if (r > 0) {
				System.out.println("Product no longer available");
			} else {
				System.out.println("Product not found");
			}
			break;
		case 6:
			List<Invoice> invoices = repo.showAllPurchases();
			if (invoices.size() > 0) {
				for(Invoice i: invoices) {
					System.out.println(i.toString());
				}
			} else {
				System.out.println("Unable to retrieve invoices.");
			}
			break;
		case 7:
			System.out.println("Enter the product id: ");
			int prodId = sc.nextInt();
			List<Invoice> productInv = repo.listAllByProduct(prodId);
			if (productInv.size() > 0) {
				for(Invoice i: productInv) {
					System.out.println(i.toString());
				}
			} else {
				System.out.println("Unable to retrieve invoices.");
			}
			break;
		case 8:
			System.out.print("Enter Invoice Date: (yyyy-mm-dd) ");
			String date = sc.next();
			LocalDate ld = LocalDate.parse(date);
			
			List<Invoice> invList = repo.listByDate(ld);
			if (invList.size() > 0) {
				for(Invoice i: invList) {
					System.out.println(i.toString());
				}
			} else {
				System.out.println("Unable to retrieve invoices.");
			}
			break;
		case 9:
			List<Invoice> curList = repo.listPurchasesForToday();
			if(curList.size() > 0) {
				for (Invoice i: curList) {
					System.out.println(i.toString());
				}
			} else {
				System.out.println("No purchases for today");
			}
			break;
		case 10:
			sc.close();
			Runtime.getRuntime().exit(0);
		default:
			break;
		}
		adminMenu(ur, pr, u, repo);
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootProjectApplication.class, args);
		UserRepository ur = context.getBean(UserRepository.class);
		ProductRepository pr = context.getBean(ProductRepository.class);
		InvoiceRepository repo = context.getBean(InvoiceRepository.class);
		
		mainMenu(ur, pr, repo);
	}

}
