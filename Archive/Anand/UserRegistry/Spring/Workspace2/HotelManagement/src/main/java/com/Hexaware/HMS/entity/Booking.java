/**
 * 
 */
package com.Hexaware.HMS.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.Hexaware.HMS.utils.BookingStatus;

/**
 * @author pavan
 *
 */
@Entity
@Table(name = "Booking")
public class Booking {
	
	@Id
	@Column(name = "bookingid")
	private int bookingId;
	
	@Column(name = "guestid")
	private int guestId;
	
	@Column(name = "roomid")
	private int roomId;
	
	@Column(name = "hotelid")
	private int hotelId;
		
	@Column(name = "totaldays")
	private int totalDays;
	
	
	@Column(name = "bookingdate")
	private LocalDate bookingDate;
	
	@Column(name = "checkindate")
	private LocalDate checkInDate;
	
	@Column(name = "checkoutdate")
	private LocalDate checkOutDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "bookingstatus")
	private BookingStatus bookingStatus;
	
	@Column(name = "totalamount")
	private double totalAmount;

	
	public Booking() {

	}


    /**
     * @param bookingId  int 
     * @param guestId  int
     * @param roomId  int
     * @param hotelId  int
     * @param totalDays  int
     * @param bookingDate  LocalDate
     * @param checkInDate  LocalDate
     * @param checkOutDate  LocalDate
     * @param bookingStatus  BookingStatus enum
     * @param totalAmount  Double
     */
    public Booking(int bookingId, int guestId, int roomId, int hotelId, int noOfGuests, int totalDays,
            LocalDate bookingDate, LocalDate checkInDate, LocalDate checkOutDate, BookingStatus bookingStatus,
            double totalAmount) {
        super();
        this.bookingId = bookingId;
        this.guestId = guestId;
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.totalDays = totalDays;
        this.bookingDate = bookingDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingStatus = bookingStatus;
        this.totalAmount = totalAmount;
    }


    /**
     * @return the bookingId
     */
    public int getBookingId() {
        return bookingId;
    }


    /**
     * @param bookingId the bookingId to set
     */
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }


    /**
     * @return the guestId
     */
    public int getGuestId() {
        return guestId;
    }


    /**
     * @param guestId the guestId to set
     */
    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }


    /**
     * @return the roomId
     */
    public int getRoomId() {
        return roomId;
    }


    /**
     * @param roomId the roomId to set
     */
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }


    /**
     * @return the hotelId
     */
    public int getHotelId() {
        return hotelId;
    }


    /**
     * @param hotelId the hotelId to set
     */
    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }



    /**
     * @return the totalDays
     */
    public int getTotalDays() {
        return totalDays;
    }


    /**
     * @param totalDays the totalDays to set
     */
    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }




    /**
     * @return the bookingDate
     */
    public LocalDate getBookingDate() {
        return bookingDate;
    }


    /**
     * @param bookingDate the bookingDate to set
     */
    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }


    /**
     * @return the checkInDate
     */
    public LocalDate getCheckInDate() {
        return checkInDate;
    }


    /**
     * @param checkInDate the checkInDate to set
     */
    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }


    /**
     * @return the checkOutDate
     */
    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }


    /**
     * @param checkOutDate the checkOutDate to set
     */
    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


    /**
     * @return the bookingStatus
     */
    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }


    /**
     * @param bookingStatus the bookingStatus to set
     */
    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }


    /**
     * @return the totalAmount
     */
    public double getTotalAmount() {
        return totalAmount;
    }


    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }


    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", guestId=" + guestId + ", roomId=" + roomId + ", hotelId="
                + hotelId + ", totalDays=" + totalDays + ", discount=" 
                + ", bookingDate=" + bookingDate + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
                + ", bookingStatus=" + bookingStatus + ", totalAmount=" + totalAmount + "]";
    }
	
	
}
    
    


	
	
	

	

















