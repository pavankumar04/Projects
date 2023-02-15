package com.Hexaware.HMS.controller;

import java.util.List;

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

import com.Hexaware.HMS.entity.Hotel;
import com.Hexaware.HMS.service.impl.HotelService;

/**
 * 
 * @author 1000075762
 *
 */

@RestController
@RequestMapping("/api")
public class HotelController {

	 @Autowired
	    private HotelService service;
	 
	 @GetMapping("/hotel")
	    public List<Hotel> retrieveAllHotel() {
	        List<Hotel> list = service.listAllHotel();
	        return list; 
	    }
	 
	  @GetMapping("/hotel/{id}")
	    public ResponseEntity<Hotel> retrieveHotelById(@PathVariable("id") int id) {
	        Hotel s = service.findHotelById(id);
	        return ResponseEntity.ok().body(s);
	    }
	 
	  @GetMapping("/hotel/location/{location}")
	    public List<Hotel> retrieveHotelByLocation(@PathVariable("location") String location) {
	        List<Hotel> list = service.findAllHotelByLocation(location);
	        return list;
	    }
	  
	  @PostMapping("/hotel")
	    public ResponseEntity<Hotel> savehotelDetails(@RequestBody Hotel hotel) {
	        Hotel s = service.saveHotel(hotel);
	        return ResponseEntity.ok().body(s);
	    }
	  
	  @PutMapping("/hotel/phoneno/{phoneno}/{id}")
	    @Transactional
	    public ResponseEntity<String> updatePhoneNo(@PathVariable("phoneno") String phoneNo, @PathVariable("id") int id) {
	        String str = service.updatePhoneNumber(phoneNo, id);
	        return ResponseEntity.ok().body(str);
	    }
	  
	  @PutMapping("/hotel/description/{description}/{id}")
	    @Transactional
	    public ResponseEntity<String> updateDescription(@PathVariable("description") String descr, @PathVariable("id") int id) {
	        String str = service.updateHotelDescription(descr, id);
	        return ResponseEntity.ok().body(str);
	    }
	  
	  @DeleteMapping("/hotel/remove/{id}")
	    @Transactional
	     public ResponseEntity<String> removeHotel(@PathVariable("id") int id) {
	        String str = service.removeHotel(id);
	        return ResponseEntity.ok().body(str);
	    }
}
