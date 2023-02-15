/**
 * 
 */
package com.Hexaware.HMS.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hexaware.HMS.entity.Booking;
import com.Hexaware.HMS.exceptions.ResourceNotFoundException;
import com.Hexaware.HMS.service.BookingService;

/**
 * @author pavan
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BookingController {
	
	@Autowired
	private BookingService service;
	
	/**
	 * To list all bookings
	 * @return list of Booking
	 */
	@GetMapping("/booking")
	public List<Booking> showAllBookings(){
		List<Booking> bkgs = service.findAllBookings();
		return bkgs;
		
	}
	
	
	/**
	 * To get Booking Details based on bookingId
	 * @param id for the BookingId
	 * @return Booking object
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/booking/{id}")
	public Booking findByBookingId(@PathVariable("id") int id) throws ResourceNotFoundException {
		Booking bkg = service.findByBookingId(id);
		return bkg;
	}
	
	
	
	/**
	 * To get Booking Details based on guestId
	 * @param id for the GuestId
	 * @return Booking object
	 */
	@GetMapping("/booking/guest/{id}")
	public List<Booking> findByGuestId(@PathVariable("id") int id) {
		List<Booking> bkg = service.findByGuestId(id);
		return bkg;
	}
	
	
	/**
	 * To get Booking Details based on BookingStatus
	 * @param status for status value 
	 * @return list of Booking
	 */
	@GetMapping("/booking/status/{status}")
	public List<Booking> findByBookingStatus(@PathVariable("status") String status) {
		List<Booking> bkg = service.findByBookingStatus(status);
		return bkg;
	}
	
    
    /**
     * To add new booking details
     * @param booking for Booking object 
     * @return ResponseEntity<Booking> object
     */
	@PostMapping("/booking")
	public ResponseEntity<String> saveBooking(@RequestBody Booking booking){
		Booking bkg = service.saveBooking(booking);
		String str = "unable to add booking";
		if(bkg!=null) {
		    str="booking added successfully";
		}
		return ResponseEntity.ok().body(str);
	}
	
	
	/**
	 * To update Booking status
	 * @param status for new status value
	 * @param id for bookingId
	 * @return ResponseEntity<Booking> object  
	 */
	@PutMapping("/booking/status/{id}/{status}")
	@Transactional
	public ResponseEntity<String> updateBookingStatus(@PathVariable("status") String status, @PathVariable("id") int id) {
		String str = null;
		try {
			str = service.updateBookingStatus(status, id);
		} catch (ResourceNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok().body(str);
	}
	
	
	/**
	 * To update Total amount
	 * @param id for bookingId        
	 * @param amount for TotalAmount
	 * @return ResponseEntity<Booking> object  
	 */
	@PutMapping("/booking/amount/{id}/{amount}")
	@Transactional
	public ResponseEntity<String> updateTotalAmount(@PathVariable("id") int id, @PathVariable("amount") double amount) {
		String str = null;
		try {
			str = service.updateAmount(id, amount);
		} catch (ResourceNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok().body(str);
	}
	
	
	/**
	 * To update checkout date 
	 * @param id for BookingId
	 * @param date for Updated Date
	 * @return ResponseEntity<Booking> object  
	 */
	@PutMapping("/booking/checkoutdate/{id}/{date}")
	@Transactional
	public ResponseEntity<String> updateCheckOutDate(@PathVariable("id") int id, @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		String str = null;
		try {
			str = service.updateCheckOutDate(id, date);
		} catch (ResourceNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok().body(str);
	}
	
	
	/**
	 * To remove Booking Details
	 * @param id for 
	 * @return ResponseEntity<Booking> object  
	 */
	@DeleteMapping("/booking/delete/{id}")
	@Transactional
	public ResponseEntity<String> removeBookingDetails(@PathVariable("id") int id) {
		String str = service.deleteByBookingId(id);
		return ResponseEntity.ok().body(str);
	}
	
	
	 
	
	
	
	
	/**
	 * 
	 * Methods For Filtering Based On Booking, CheckOut and CheckIn Dates
	 *
	 */
	
	
    //  BOOKING DATE METHODS
	
	/**
     * To get Booking Details based on bookingDate
     * @param date for the bookingDate
     * @return list of Bookings
     */
	
    @GetMapping("/booking/bookingdate/{date}")
    public List<Booking> findByBookingDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Booking> bkg = service.findByBookingDate(date);
        return bkg;
    }
    
    
    /**
     * To get Booking Details booked after a particular date
     * @param date for a particular date chosen
     * @return list of Bookings
     */
    @GetMapping("/booking/bookingdate/greaterthan/{date}")
    public List<Booking> findByBookingDateGreaterThan(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Booking> bkg = service.findByBookingDateGreaterThan(date);
        return bkg;
    }
    
    
    /**
     * To get Booking Details booked before a particular date
     * @param date for a particular date chosen
     * @return list of Bookings
     */
    @GetMapping("/booking/bookingdate/lessthan/{date}")
    public List<Booking> findByBookingDateLessThan(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Booking> bkg = service.findByBookingDateLessThan(date);
        return bkg;
    }
    
    
    

    //  CHECK IN DATE METHODS  
    
    
    /**
     * To get Booking Details based on checkInDate
     * @param date for the checkInDate
     * @return list of Bookings
     */
    @GetMapping("/booking/checkindate/{date}")
    public List<Booking> findBycheckInDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Booking> bkg = service.findByCheckInDate(date);
        return bkg;
    }
    
    
    /**
     * To get Booking Details where checkInDate is after a particular date
     * @param date for a particular date chosen
     * @return list of Bookings
     */
    @GetMapping("/booking/checkindate/greaterthan/{date}")
    public List<Booking> findBycheckInDateGreaterThan(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Booking> bkg = service.findByCheckInDateGreaterThan(date);
        return bkg;
    }
    
    
    /**
     * To get Booking Details where checkInDate is before a particular date
     * @param date for a particular date chosen
     * @return list of Bookings
     */
    @GetMapping("/booking/checkindate/lessthan/{date}")
    public List<Booking> findBycheckInDateLessThan(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Booking> bkg = service.findByCheckInDateLessThan(date);
        return bkg;
    }
    
    
    
    //  CHECK OUT DATE METHODS
    
    
    /**
     * To get Booking Details based on checkOutDate
     * @param date for the checkOutDate
     * @return list of bookings
     */
    @GetMapping("/booking/checkoutdate/{date}")
    public List<Booking> findBycheckOutDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Booking> bkg = service.findByCheckOutDate(date);
        return bkg;
    }
    
    
    /**
     * To get Booking Details where checkOutDate is after a particular date
     * @param date for a particular date chosen
     * @return list of Bookings
     */
    @GetMapping("/booking/checkoutdate/greaterthan/{date}")
    public List<Booking> findBycheckOutDateGreaterThan(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Booking> bkg = service.findByCheckOutDateGreaterThan(date);
        return bkg;
    }
    
    
    /**
     * To get Booking Details where checkOutDate is before a particular date
     * @param date for a particular date chosen
     * @return list of Bookings
     */
    @GetMapping("/booking/checkoutdate/lessthan/{date}")
    public List<Booking> findBycheckOutDateLessThan(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Booking> bkg = service.findByCheckOutDateLessThan(date);
        return bkg;
    }
    

}
