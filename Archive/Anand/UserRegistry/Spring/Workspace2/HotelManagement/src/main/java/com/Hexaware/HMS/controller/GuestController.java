package com.Hexaware.HMS.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hexaware.HMS.entity.Guest;
import com.Hexaware.HMS.service.GuestService;
import com.Hexaware.HMSexception.ResourceNotFoundException;


/**
 * Rest API for Guest
 * @author 1000075793
 *
 */
@RestController
@RequestMapping("/api")
public class GuestController {
    @Autowired
    private GuestService service;
    
    /**
     * to get Guest details based on email
     * @param email for the email
     * @return ResponseEntity<Guest> object
     */
    @GetMapping("/guest/email/{email}")
    public ResponseEntity<Guest> retrieveByEmail(@PathVariable("email") String email){
    	Guest c = null;
        try {
            c = service.retrieveByEmail(email);
        } catch (ResourceNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return ResponseEntity.ok().body(c);
    }
    

    
    /**
     * to get Guest details based on id.
     * @param id for the Guest id
     * @return ResponseEntity<Guest> object
     */
    @GetMapping("/guests/{id}")
    public ResponseEntity<Guest> retrieveGuestById(@PathVariable("id") int id){
    	Guest c = null;
        try {
            c = service.retrieveGuestById(id);
        } catch (ResourceNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return ResponseEntity.ok().body(c);
    }

    /**
     * to upload new Guest details
     * @param Guest for the Guest object
     * @return ResponseEntity<Guest> object
     */
    @PostMapping("/guests")
    public ResponseEntity<Guest> saveGuest(@RequestBody Guest guest) {
    	Guest c = service.saveGuest(guest);
        
        return ResponseEntity.ok().body(c);
    }
    
    /**
     * to update the Guest password
     * @param password for the password
     * @param id for the Guest id
     * @return ResponseEntity<String>
     */
    @PutMapping("/guests/password/{Passcode}/{id}")
    @Transactional
    public ResponseEntity<String> updatePassword(@PathVariable("Passcode") String password, @PathVariable("id") int id) {
        String str = service.updatePassword(password, id);
        return ResponseEntity.ok().body(str);
    }
    
    /**
     * to update the Guest wallet balance
     * @param wallet for the wallet amount
     * @param id for the Guest id
     * @return ResponseEntity<String>
     */
    @PutMapping("/guests/wallet/{wallet}/{id}")
    @Transactional
    public ResponseEntity<String> updateWallet(@PathVariable("wallet") double wallet, @PathVariable("id") int id) {
        String str = service.updateWallet(wallet, id);
        return ResponseEntity.ok().body(str);
    }
    
    /**
     * to update the Guest phone
     * @param phone for the phone
     * @param id for the Guest id
     * @return ResponseEntity<String>
     */
    @PutMapping("/guests/phone/{phone}/{id}")
    @Transactional
    public ResponseEntity<String> updatePhone(@PathVariable("phone") String phone, @PathVariable("id") int id) {
        String str = service.updatePhone(phone, id);
        return ResponseEntity.ok().body(str);
    }
    
    @DeleteMapping("/guest/removeguest/{id}")
    @Transactional
    
    public ResponseEntity<String> DeleteByGuestId(@PathVariable("id") int id){
    	String str= service.DeleteByGuestId(id);
    	return ResponseEntity.ok().body(str);
    }
}
