/**
 * 
 */
package com.Hexaware.HMS.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Hexaware.HMS.entity.Booking;
import com.Hexaware.HMS.utils.BookingStatus;

/**
 * @author pavan
 *
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

	public List<Booking> findAllByGuestId(int id);
	public Booking findAllByBookingId(int id);
	public List<Booking> findAllByBookingStatus(BookingStatus status);
	
	public List<Booking> findAllByBookingDate(LocalDate date);
	public List<Booking> findAllByBookingDateGreaterThan(LocalDate date);
	public List<Booking> findAllByBookingDateLessThan(LocalDate date);
	
	public List<Booking> findAllByCheckInDate(LocalDate date);
	public List<Booking> findAllByCheckInDateGreaterThan(LocalDate date);
	public List<Booking> findAllByCheckInDateLessThan(LocalDate date);
	
	public List<Booking> findAllByCheckOutDate(LocalDate date);
	public List<Booking> findAllByCheckOutDateGreaterThan(LocalDate date);
	public List<Booking> findAllByCheckOutDateLessThan(LocalDate date);

	
	@Query(value = "SELECT * FROM BOOKING ORDER BY BOOKINGID DESC LIMIT 1", nativeQuery=true)
	public Booking findTopByOrderByOrderIdDesc();
	
	@Modifying
	@Query(value = "UPDATE BOOKING SET BOOKINGSTATUS = :status WHERE BOOKINGID = :id", nativeQuery=true)
	public int updateBookingStatus(@Param("status") String status, @Param("id") int id);
	
	@Modifying
	@Query(value = "UPDATE BOOKING SET TOTALAMOUNT = :amount WHERE BOOKINGID = :id", nativeQuery=true)
	public int updateAmount(@Param("amount") double amount, @Param("id") int id);
	
	@Modifying
	@Query(value = "UPDATE BOOKING SET CHECKOUTDATE = :date WHERE BOOKINGID = :id", nativeQuery=true)
	public int updateCheckOutDate( @Param("date") LocalDate date, @Param("id") int id);
	
	@Modifying
	@Query(value = "DELETE FROM BOOKING WHERE BOOKINGID = :id", nativeQuery=true)
	public int deleteByBookingId(@Param("id") int id);
	
}










