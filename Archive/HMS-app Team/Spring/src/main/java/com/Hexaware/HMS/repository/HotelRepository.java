package com.Hexaware.HMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Hexaware.HMS.entity.Hotel;
/**
 * 
 * @author 1000075762
 *
 */

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

	
	public List<Hotel> findAllHotelByHotelLocation(String location);
	
	@Modifying
	@Query(value = "UPDATE HOTEL SET HOTELPHONENO = :phoneno WHERE HOTELID = :id", nativeQuery = true)
	public int updatePhoneNumber(@Param("phoneno") String phoneNo ,@Param("id") int id);
	
	@Modifying
	@Query(value = "UPDATE HOTEL SET DESCRIPTION = :descr WHERE HOTELID = :id", nativeQuery = true)
	public int updateDescription(@Param("descr") String descr,@Param("id") int id);
	
	@Modifying
	@Query(value = "DELETE FROM HOTEL WHERE HOTELID = :id", nativeQuery = true)
	public int deleteHotel(@Param("id") int id);
	
	
	}
