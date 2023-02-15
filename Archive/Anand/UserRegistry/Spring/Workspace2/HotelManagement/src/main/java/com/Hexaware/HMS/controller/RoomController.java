package com.Hexaware.HMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hexaware.HMS.entity.Room;
import com.Hexaware.HMS.service.RoomService;

/**
 * Room Controller
 * @author 1000075689 (GIRISH KUMAR MARU)
 *
 */
@RestController
@RequestMapping("/api")
public class RoomController {
	@Autowired
	private RoomService service;
	
	@GetMapping("/rooms")
	public List<Room> retrieveAllRooms(){
		List<Room> room=service.retrieveAllRooms();
		return room;
	}
	@GetMapping("/rooms/hotel/{id}")
	public List<Room> retrieveHotelId(@PathVariable("id") int id){
		List<Room> room=service.retrieveHotelId(id);
		return room;
	}
	@GetMapping("/rooms/room/{id}")
	public Room retrieveRoomId(@PathVariable("id") int id){
		Room room=service.retrieveRoomById(id);
		return room;
	}
	@PostMapping("/addroom")
	public ResponseEntity<Room> addRoom(@RequestBody Room room){
		Room r=service.addRoom(room);
		return ResponseEntity.ok().body(r);	
	}
	
	@PutMapping("/room/cost/{cost}/{id}")
	@Transactional
	public ResponseEntity<String> updateRoomCost(@PathVariable("cost") double cost,@PathVariable("id") int id){
		String str=service.updateRoomCost(cost,id);
		return ResponseEntity.ok().body(str);
	}
	
	@PutMapping("/rooms/updateavailabilty/{availability}/{id}")
	@Transactional
	public ResponseEntity<String> updateAvailability(@PathVariable("availability")boolean availability,@PathVariable("id") int id){
		String str=service.updateAvailability(availability,id);
		return ResponseEntity.ok().body(str);
	
	}
	
	@GetMapping("/rooms/avail/{availability}")
	public List<Room> listByAvailability(@PathVariable("availability") boolean availability){
		List<Room> room=service.listByAvailability(availability);
		return room;
	}
	
	@GetMapping("/rooms/type/{roomType}")
	public List<Room> listByRoomType(@PathVariable("roomType") String roomType){
		List<Room> room=service.listByRoomType(roomType);
		return room;
		
	}
	
	@GetMapping("/rooms/filterbycost/{max}/{min}")
	public List<Room> filterByCost(@PathVariable("max") double upr,@PathVariable("min") double lwr){
		List<Room> room=service.filterByCost(upr, lwr);
		return room;
		
		
	}
	
	
	@DeleteMapping("/rooms/removeroom/{id}")
	@Transactional
	public ResponseEntity<String> deleteByRoomId(@PathVariable("id") int id){
		String str=service.deleteByRoomId(id);
		return ResponseEntity.ok().body(str);
		
		
	}
	
}

