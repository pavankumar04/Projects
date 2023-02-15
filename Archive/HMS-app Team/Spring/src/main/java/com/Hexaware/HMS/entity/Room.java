package com.Hexaware.HMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author 1000075689 (GIRISH KUMAR MARU)
 *
 */

@Entity
@Table(name="room")
public class Room {
	@Id
	@Column(name="roomid")
	private int roomId;
	
	@Column(name="hotelid")
	private int hotelId;
	
	@Column(name="roomtype")
	private String roomType;
	
	@Column(name="roomcost")
	private double roomCost;
	
	@Column(name="roomavailability")
	private boolean roomAvailability;
	
	public Room() {
		
	}
	
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getRoomCost() {
		return roomCost;
	}

	public void setRoomCost(double roomCost) {
		this.roomCost = roomCost;
	}

	public boolean getRoomAvailability() {
		return roomAvailability;
	}

	public void setRoomAvailability(boolean roomAvailability) {
		this.roomAvailability = roomAvailability;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", hotelId=" + hotelId + ", roomType=" + roomType + ", roomCost=" + roomCost
				+ ", roomAvailability=" + roomAvailability + "]";
	}

	/**
	 * 
	 * to sting method
	 * @param roomId
	 * @param hotelId
	 * @param roomType
	 * @param roomCost
	 * @param roomAvailability
	 */
	public Room(int roomId, int hotelId, String roomType, double roomCost, boolean roomAvailability) {
		super();
		this.roomId = roomId;
		this.hotelId = hotelId;
		this.roomType = roomType;
		this.roomCost = roomCost;
		this.roomAvailability = roomAvailability;
	}
	
	
}
