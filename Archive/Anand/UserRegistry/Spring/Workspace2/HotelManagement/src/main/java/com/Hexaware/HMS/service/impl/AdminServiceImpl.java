package com.Hexaware.HMS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hexaware.HMS.entity.Admin;
import com.Hexaware.HMS.repository.AdminRepository;

@Service
public class AdminServiceImpl {
    
    @Autowired
    private AdminRepository repo;
    
    /**
     * To get Admin details by email
     * @param email
     * @return
     */
    public Admin retrieveAdminByEmail(String email) {
        Admin a = repo.findByEmail(email);
        return a;
    }
    
    /**
     * To get Admin details by id
     * @param id
     * @return
     */
    public Admin retrieveAdminById(long id) {
        Admin a = repo.findById(id).get();
        return a;
    }
    
    /**
     * to update password.
     * @param pass for the new password - String
     * @param id for the employee id - long
     * @return String
     */
    public String updatePassword(String pass, long id) {
        String msg = "Unable to update password";
        
        int res = repo.updatePassword(pass, id);
        
        if (res > 0) {
            msg = "Password updated";
        }
        
        return msg;
    }
    
    /**
     * to update Email Id
     * @param ph for the new phone number - String
     * @param id for the employee id - long
     * @return String
     */
    public String updatePhone(String em, long id) {
        String str = "Unable to update Email Id";
        int res = repo.updateEmail(em, id);
        
        if (res > 0) {
            str = "Email Id updated";
        }
        
        return str;
    }
    
    
}