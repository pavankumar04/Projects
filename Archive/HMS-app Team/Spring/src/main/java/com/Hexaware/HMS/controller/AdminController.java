package com.Hexaware.HMS.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hexaware.HMS.entity.Admin;
import com.Hexaware.HMS.exceptions.ResourceNotFoundException;
import com.Hexaware.HMS.service.impl.AdminServiceImpl;

/**
 * Rest API for Admin 
 * @author 1000075894
 *
 */
@RestController
@RequestMapping("/api")
public class AdminController {
    
    @Autowired
    private AdminServiceImpl service;
    
    @GetMapping("/admin/email/{email}")
    public ResponseEntity<Admin> retrieveCustomerByEmail(@PathVariable("email") String email) throws ResourceNotFoundException {
            Admin a = service.retrieveAdminByEmail(email);
        
            if (a == null) {
                throw new ResourceNotFoundException("Admin with email: " + email + " not found");
            }
        
        return ResponseEntity.ok().body(a);
        }
    
     @GetMapping("/admin/{id}")
     public ResponseEntity<Admin> retrieveCustomerById(@PathVariable("id") long id) throws ResourceNotFoundException {
            Admin a = service.retrieveAdminById(id);
            
            if (a == null) {
                throw new ResourceNotFoundException("Admin with id: " + id + " not found");
            }
            
            return ResponseEntity.ok().body(a);
        }
     
     @PutMapping("/admin/password/{passcode}/{id}")
     @Transactional
     public ResponseEntity<String> updatePassword(@PathVariable("passcode") String passcode, @PathVariable("id") long id) {
            String str = service.updatePassword(passcode, id);
            return ResponseEntity.ok().body(str);
        }
     
     @PutMapping("/admin/email/{email}/{id}")
     @Transactional
     public ResponseEntity<String> updatePhone(@PathVariable("email") String email, @PathVariable("id") long id) {
            String str = service.updatePhone(email, id);
            return ResponseEntity.ok().body(str);
        }
     
     
}