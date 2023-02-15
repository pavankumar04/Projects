/**
 * 
 */
package com.Hexaware.HMS.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hexaware.HMS.entity.Booking;
import com.Hexaware.HMS.exceptions.ResourceNotFoundException;
import com.Hexaware.HMS.repository.BookingRepository;
import com.Hexaware.HMS.utils.BookingStatus;

/**
 * @author pavan
 *
 */
@Service
public class BookingService {
	
	@Autowired
	private BookingRepository repo;
	final int INITIAL_ID = 700;
	
	
	/**
	 * To list all Bookings
	 * @return list of Bookings
	 */
	public List<Booking> findAllBookings(){
		List<Booking> bkgs = repo.findAll();
		return bkgs;
	}
	 
	
	/**
	 * To get Booking Details based on bookingId
	 * @param id for the bookingId
	 * @return booking object
	 */
	public Booking findByBookingId(int id)throws ResourceNotFoundException{
		Booking bkg = repo.findAllByBookingId(id);
		return bkg;
	}
	
	
	/**
	 * To get Booking Details based on guestId
	 * @param id for the guestId
	 * @return list of Bookings
	 */
	public List<Booking> findByGuestId(int id){
		List<Booking> bkgs = repo.findAllByGuestId(id);
		return bkgs;
	}
	

	/**
	 * To add new booking details
	 * @param booking for the booking object
	 * @return 
	 */
	public Booking saveBooking(Booking booking) {
        Booking bkg = repo.findTopByOrderByOrderIdDesc();
		int id = INITIAL_ID;
		if(bkg != null) {
			id = bkg.getBookingId() + 1;
		}
		booking.setBookingId(id);
		bkg = repo.save(booking);
		return bkg;
	}
	

	
	/**
	 * To get Booking Status based on BookingID
	 * @param status
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public String updateBookingStatus(String status, int id) throws ResourceNotFoundException{
		String str = "Unable to update status";
		Booking bkg = repo.findAllByBookingId(id);
		if(bkg == null) {
			throw new ResourceNotFoundException("Order details not found");
		}
		int res = repo.updateBookingStatus(status, id); 
        if(res > 0) {
            str = "Booking status updated";
        }
		return str;
	}
	
	
	/**
     * To update Total amount
     * @param id for bookingId        
     * @param amount for TotalAmount
     * @return string  
     */
	public String updateAmount(int id, double amount) throws ResourceNotFoundException{
		String str = "Unable to update Amount";
		Booking bkg = repo.findAllByBookingId(id);
		if(bkg == null) {
			throw new ResourceNotFoundException("Order details not found");
		}
		int res = repo.updateAmount(amount, id);
		if(res > 0) {
			str = "Total Amount is updated";
		}
		return str;
	}
	
	
	/**
     * To update checkout date 
     * @param id for BookingId
     * @param date for Updated Date
     * @return String  
     */
	public String updateCheckOutDate(int id, LocalDate date) throws ResourceNotFoundException{
		String str = "Unable to update CheckOut Date";
		Booking bkg = repo.findAllByBookingId(id);
		if(bkg == null) {
			throw new ResourceNotFoundException("Order details not found");
		}
		int res = repo.updateCheckOutDate(date, id);
		if(res > 0) {
			str = "CheckOut Date is successfully updated";
		}
		return str;	
	}
	
	
	/**
     * To remove Booking Details
     * @param id for 
     * @return String
     */
	public String deleteByBookingId(int id) {
		String str = "Unable to delete booking details";
		int res = repo.deleteByBookingId(id);
		
		if (res > 0) {
			str = "Booking details have been deleted";
		}
		return str;
	}
	
	
	
	/**
	 * To get Booking Details based on bookingStatus
	 * @param date for the bookingStatus
	 * @return list of Bookings
	 */
	public List<Booking> findByBookingStatus(String status){
		BookingStatus bkStatus = BookingStatus.valueOf(status.toUpperCase());
		List<Booking> bkgs = repo.findAllByBookingStatus(bkStatus);
		return bkgs;
	}
	
	
	/**
	 * To get Booking Details based on bookingDate
	 * @param date for the bookingDate
	 * @return list of Bookings
	 */
	public List<Booking> findByBookingDate(LocalDate date){
		List<Booking> bkgs = repo.findAllByBookingDate(date);
		return bkgs;
	}
	
	
	/**
     * To get Booking Details booked after a particular date
     * @param date for a particular date chosen
     * @return list of Bookings
     */
    public List<Booking> findByBookingDateGreaterThan(LocalDate date){
        List<Booking> bkgs = repo.findAllByBookingDateGreaterThan(date);
        return bkgs;
    }
	
	
	/**
	 * To get Booking Details booked before a particular date
	 * @param date for a particular date chosen
	 * @return list of Bookings
	 */
	public List<Booking> findByBookingDateLessThan(LocalDate date){
		List<Booking> bkgs = repo.findAllByBookingDateLessThan(date);
		return bkgs;
	}
	
	
	
	/**
	 * To get Booking Details based on checkInDate
	 * @param date for the checkInDate
	 * @return list of Bookings
	 */
	public List<Booking> findByCheckInDate(LocalDate date){
		List<Booking> bkgs = repo.findAllByCheckInDate(date);
		return bkgs;
	}
	
	
	/**
	 * To get Booking Details where checkInDate is after a particular date
	 * @param date for a particular date chosen
	 * @return list of Bookings
	 */
	public List<Booking> findByCheckInDateGreaterThan(LocalDate date){
		List<Booking> bkgs = repo.findAllByCheckInDateGreaterThan(date);
		return bkgs;
	}
	
	
	/**
	 * To get Booking Details where checkInDate is before a particular date
	 * @param date for a particular date chosen
	 * @return list of Bookings
	 */
	public List<Booking> findByCheckInDateLessThan(LocalDate date){
		List<Booking> bkgs = repo.findAllByCheckInDateLessThan(date);
		return bkgs;
	}
	
	
	
	/**
	 * To get Booking Details based on checkOutDate
	 * @param date for the checkOutDate
	 * @return list of bookings
	 */
	public List<Booking> findByCheckOutDate(LocalDate date){
		List<Booking> bkgs = repo.findAllByCheckOutDate(date);
		return bkgs;
	}
	
	
	/**
	 * To get Booking Details where checkOutDate is after a particular date
	 * @param date for a particular date chosen
	 * @return list of Bookings
	 */
	public List<Booking> findByCheckOutDateGreaterThan(LocalDate date){
		List<Booking> bkgs = repo.findAllByCheckOutDateGreaterThan(date);
		return bkgs;
	}
	
	
	/**
	 * To get Booking Details where checkOutDate is before a particular date
	 * @param date for a particular date chosen
	 * @return list of Bookings
	 */
	public List<Booking> findByCheckOutDateLessThan(LocalDate date){
		List<Booking> bkgs = repo.findAllByCheckOutDateLessThan(date);
		return bkgs;
	}
	

}








