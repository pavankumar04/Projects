package com.Hexaware.HMS.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Guest Class
 * @author 1000075793
 *
 */

@Entity
@Table(name = "guest")

public class Guest {
	@Id
   @Column(name="guestid")
   private int guestId;
	
   @Column(name="firstname")
   private String firstName;
   
   @Column(name="lastname")
   private String lastName;
   
   @Column(name="address")
   private String address;
   
   @Column(name="Phone")
   private String Phone;
   
   @Column(name="email")
   private String email;
   
   @Column(name="wallet")
   private int wallet;
   
   @Column(name="passcode")
   private String Passcode;
   
   /**
	 * 
	 */
	public Guest() {
		
	}

	
	/**
	 * @param guestId
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param Phone
	 * @param email
	 * @param wallet
	 * @param Passcode
	 */

   
   
public int getGuestId() {
	return guestId;
}
public void setGuestId(int guestId) {
	this.guestId = guestId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	Phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getWallet() {
	return wallet;
}
public void setWallet(int wallet) {
	this.wallet = wallet;
}
public String getPasscode() {
	return Passcode;
}
public void setPasscode(String passcode) {
	Passcode = passcode;
}
@Override
public String toString() {
	return "Guest [guestId=" + guestId + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
			+ ", Phone=" + Phone + ", email=" + email + ", wallet=" + wallet + ", Passcode=" + Passcode + "]";
}
public Guest(int guestId, String firstName, String lastName, String address, String phone, String email, int wallet,
		String passcode) {
	super();
	this.guestId = guestId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	Phone = phone;
	this.email = email;
	this.wallet = wallet;
	Passcode = passcode;
}
   
   
   
}
