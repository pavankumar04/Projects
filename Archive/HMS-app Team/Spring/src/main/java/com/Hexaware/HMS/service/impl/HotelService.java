package com.Hexaware.HMS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hexaware.HMS.entity.Hotel;
import com.Hexaware.HMS.repository.HotelRepository;
/**
 * 
 * @author 1000075762
 *
 */

@Service
public class HotelService {

	@Autowired
	private HotelRepository repo;
	
	/**
	 * to get list of all hotel
	 * 
	 */
	 public List<Hotel> listAllHotel() {
	        List<Hotel> list = repo.findAll();
	        return list;
	    }
	 
	 /**
	  * find hotel by id
	  * @param id
	  * @return hotel object
	  */
	 public Hotel findHotelById(int id) {
	        Hotel hotel = repo.findById(id).get();
	        return hotel;
	    }
	 
	 /**
	  * find all hotel by location
	  * @param location
	  * @return list 
	  */
	 public List<Hotel> findAllHotelByLocation(String location){
		 List<Hotel> list = repo.findAllHotelByHotelLocation(location);
		 return list;
	 }
	 /**
	  * 
	  * @param hotel
	  * @return h object
	  */
	 public Hotel saveHotel(Hotel hotel) {
	       
	        Hotel h = repo.save(hotel);
	        return h;
	    }
	
	 /**
	  * update phone number
	  * @param phoneNo
	  * @param id
	  * @return str
	  */
	 public String updatePhoneNumber(String phoneNo, int id) {
		 String str = "Value not Updated";
		 
			int tut =repo.updatePhoneNumber(phoneNo, id);
		if(tut > 0){
			str = "Value updated successfully";
		}
			return str;
		}
	 /**
	  * update phone number
	  * @param descr
	  * @param id
	  * @return
	  */
	 public String updateHotelDescription(String descr, int id) {
		 String str = "Value not Updated";
		 
			int tut =repo.updateDescription(descr, id);
		if(tut > 0){
			str = "Value updated successfully";
		}
			return str;
		}
	 
	 /**
	  * remove hotel
	  * @param id
	  * @return
	  */
	 public String removeHotel(int id) {

	        String str = "Unable to delete Hotel details";
	        int res = repo.deleteHotel(id);
	        
	        if (res > 0) {
	            str = "Hotel details have been deleted";
	        }
	        
	        return str;
	 	}
}
