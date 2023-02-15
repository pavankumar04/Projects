package com.Hexaware.HMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hexaware.HMS.entity.Guest;
import com.Hexaware.HMS.repository.GuestRepository;
import com.Hexaware.HMSexception.ResourceNotFoundException;


/**
 * Service class for Guest
 * @author 1000075793
 *
 */

@Service
public class GuestService {
    
    @Autowired
    private GuestRepository repo;
    
    /**
     * To get Guest details based on email.
     * @param email for the email String
     * @return Guest object
     * @throws ResourceNotFoundException for the exception
     */
    public Guest retrieveByEmail(String email) throws ResourceNotFoundException {
    	Guest c = repo.findByEmail(email);
        
        if (c == null) {
            throw new ResourceNotFoundException("Guest with email: " + email + " not found");
        }
        
        return c;
    }
    
    /**
     * to get Guest details based on Guest id
     * @param id for the Guest id - long
     * @return Guest object
     * @throws ResourceNotFoundException for the exception
     */
    public Guest retrieveGuestById(int id) throws ResourceNotFoundException {
    	Guest c = repo.findById(id);
        
        if (c == null) {
            throw new ResourceNotFoundException("Guest with id: " + id + " not found");
        }
        return c;
    }
    
    /**
     * to add new Guest details.
     * @param Guest for the Guest object
     * @return Guest object
     */
    public Guest saveGuest(Guest guest) {
        //String str = "Unable to upload Guest details";
    	Guest c = repo.findTopByOrderByGuestIdDesc();
        
        int id = 101;
        if (c != null) {
            id = c.getGuestId() + 1;
            
        }
        guest.setGuestId(id);
        
        c = repo.save(guest);
        
        return c;
    }
    
    /**
     * to update password.
     * @param pass for the new password - String
     * @param id for the Guest id - long
     * @return String
     */
    public String updatePassword(String pass, int id) {
        String str = "Unable to update password";
        
        int res = repo.updatePassword(pass, id);
        if(res > 0) {
            str = "Password updated";
        }
        
        return str;
    }
    
    /**
     * to update phone number.
     * @param ph for the new phone number - String
     * @param id for the Guest id - long
     * @return String
     */
    public String updatePhone(String ph, int id) {
        String str = "Unable to update Phone number";
        
        int res = repo.updatePhone(ph, id);
        if(res > 0) {
            str = "Phone number updated";
        }
        
        return str;
    }
    
    /**
     * to update the wallet amount
     * @param wallet for the wallet amount
     * @param id for the Guest id
     * @return String
     */
    public String updateWallet(double wallet, int id) {
        String str = "Unable to update wallet";
        
        int res = repo.updateWalletAmount(wallet, id);
        if(res > 0) {
            str = "Wallet amount updated";
        }
        
        return str;
    }
    
    /**
     * to delete guest details
     * @param id
     * @return
     */
    public String DeleteByGuestId(int id) {
    	String m="Unable to delete type correct Id";
    	int res=repo.DeleteByGuestId(id);
    	if(res>0) {
    		m="The guest details has deleted";
    	}
    	return m;
    	
    }
    
    
    
}