package com.Hexaware.HMS.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Hexaware.HMS.entity.Room;
import com.Hexaware.HMS.repository.RoomRepository;

/**
 * ROOM SERVICES
 * @author 1000075689 (GIRISH KUMAR MARU)
 *
 */

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository repo;
	
	/**
	 * show all rooms
	 * @return  LIST ROOM
	 */
	public List<Room> retrieveAllRooms(){
		List<Room> room=repo.findAll();
		return room;
		
	}
	/**
	 * show the room details by room id
	 * @param id
	 * @return ROOM object
	 */
	public Room retrieveRoomById(int id) {
		Room r=repo.findByRoomId(id);
		return r;	
				
	}
	
	/**
	 * 
	 * @param availability
	 * @return list room
	 */
	public List<Room> listByAvailability(Boolean availability){
		List<Room> room=repo.findByRoomAvailability(availability);
		return room;
	}
	
	/**
	 * 
	 * @param id
	 * @return list of room by hotel id 
	 */
	public List<Room> retrieveHotelId(int id) {
		List<Room> r=repo.findByHotelId(id);
		return r;
		
	}
	/**
	 * Add room
	 * @param room
	 * @return 
	 */
	public Room addRoom(Room room) {
		Room o = repo.findTopByOrderByRoomIdDesc();
		int id =101;
		
		if(o!=null) {
			id =o.getRoomId()+1;
			
		}
		room.setRoomId(id);
		o=repo.save(room);
		return o;	
	}
	
	/**
	 * update room cost by room id 
	 * @param cost
	 * @param id
	 * @return
	 */
	public String updateRoomCost(double cost,int id) {
		String m ="unable to upadate RoomCost";
		int res =repo.updateRoomCost(cost, id);
		if (res>0) {
			m="room cost upadated ";		
		} return m;
		
				
	}
	
	
	
	/**
	 * update availability of room by room id
	 * @param availability
	 * @param id
	 * @return
	 */
	public String updateAvailability(boolean availability,int id) {
		String m ="unable to upadate Room availability";
		int res =repo.updateRoomAvailability(availability, id);
		if (res>0) {
			m="room availability upadated ";		
			
		}return m;
	}
	
	
	/**
	 * 
	 * @param roomType
	 * @return list room by room type
	 */
	
	public List<Room> listByRoomType(String roomType){
		List<Room> room=repo.findByRoomType(roomType);
		return room;
	}
	
	
	/**
	 * 
	 * @param upr max cost of  room
	 * @param lwr lowest cost of room 
	 * @return list by filtering cost
	 * 
	 */
	public List<Room> filterByCost(double upr ,double lwr){
		List<Room> room=repo.filterByCost(upr, lwr);
		return room;
		
		
	}
	
	/**
	 * delete room by room id
	 * @param id
	 * @return
	 */
	
	public String deleteByRoomId(int id) {
		String m="Unable to delete the room details";
		int res=repo.deleteByRoomId(id);
		if(res>0) {
			m="Room details got deleted";
		}
		return m;
		
	}
	
	


}
	


