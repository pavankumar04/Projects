package com.Hexaware.HMS.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Hexaware.HMS.entity.Room;
/**
 * ROOM REPOSITORY
 * @author 1000075689 (MARU GIRISH KUMAR)
 *
 */

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer>{
	/**
	 * 
	 * @param id
	 * @return ROOM by room id 
	 */
	public Room findByRoomId(int id);
	
	/**
	 * 
	 * @param id
	 * @return list room by hotel id 
	 */
	
	public List<Room> findByHotelId(int id);
	
	/**
	 * 
	 * @return room 
	 */
	public Room findTopByOrderByRoomIdDesc();
	
	
	/**
	 * 
	 * @param cost
	 * @param id
	 * @return integer
	 */
	@Modifying
	@Query(value = "UPDATE ROOM SET ROOMCOST = :cost WHERE ROOMID= :id", nativeQuery=true)
	public int updateRoomCost(@Param("cost") double cost, @Param("id") int id);
	
	
	/**
	 * 
	 * @param availability
	 * @param id
	 * @return integer to the confirmation of update 
	 */
	@Modifying
	@Query(value = "UPDATE ROOM SET ROOMAVAILABILITY = :availability WHERE ROOMID = :id", nativeQuery=true)
	public int updateRoomAvailability(@Param("availability") boolean availability, @Param("id") int id);
	
	
	/**
	 * 
	 * @param id
	 * @return integer to the confirmation of deletion
	 */
	@Modifying
	@Query(value = "DELETE FROM ROOM WHERE ROOMID = :id", nativeQuery=true)
	public int deleteByRoomId(@Param("id") int id);
	
	
	
	
	
	/**
	 * 
	 * @param availability
	 * @return list room by room availability
	 */
	@Query(value = "SELECT * FROM ROOM WHERE ROOMAVAILABILITY = :availability", nativeQuery=true)
	public List<Room> findByRoomAvailability(@Param("availability") boolean availability);
	
	
	/**
	 * 
	 * @param roomType
	 * @return list room by room type
	 */
	@Query(value="SELECT * FROM ROOM WHERE ROOMTYPE=:roomType",nativeQuery=true)
	public List<Room> findByRoomType(@Param("roomType") String roomType);
	
	
	/**
	 * 
	 * @param upr for the max range 
	 * @param lwr for the least range 
	 * @return list by filtering cost
	 * 
	 */
	@Query(value="SELECT * FROM ROOM WHERE ROOMCOST <:UPR AND ROOMCOST >:LWR",nativeQuery=true)
	public List<Room> filterByCost(@Param("UPR")double upr ,@Param("LWR")double lwr);
	 
}
