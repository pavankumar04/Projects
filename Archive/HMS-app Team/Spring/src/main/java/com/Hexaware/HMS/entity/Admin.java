package com.Hexaware.HMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Admin Class
 * @author 1000075894
 *
 */
@Entity
@Table(name = "admin")
public class Admin {
    
    @Id
    @Column(name = "adminid")
    private int adminId;
    
    @Column(name = "firstname")
    private String firstName;
    
    @Column(name = "lastname")
    private String lastName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "passcode")
    private String passcode;
    
    /**
     * Default Constructor
     */
    public Admin() {
        
    }

    /**
     * @param adminId int 
     * @param firstName String
     * @param lastName String
     * @param email String
     * @param passcode String
     */
    public Admin(int adminId, String firstName, String lastName, String email, String passcode) {
        super();
        this.adminId = adminId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passcode = passcode;
    }

    /**
     * @return the adminId
     */
    public int getAdminId() {
        return adminId;
    }

    /**
     * @param adminId the adminId to set
     */
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the passcode
     */
    public String getPasscode() {
        return passcode;
    }

    /**
     * @param passcode the passcode to set
     */
    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    
    /**
     * toString Method
     */
    @Override
    public String toString() {
        return "Admin [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", passcode=" + passcode + "]";
    }
    
    
}