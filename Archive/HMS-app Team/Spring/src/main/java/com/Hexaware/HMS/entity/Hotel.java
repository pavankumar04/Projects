/**
 * 
 */
package com.Hexaware.HMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author 1000075762
 *
 */

@Entity
@SequenceGenerator(name="seq" , initialValue = 201, allocationSize = 300)
@Table(name = "hotel")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "hotelid")
	private int hotelId;
	
	@Column(name = "hotelname")
	private String hotelName;
	
	@Column(name = "hoteladdress")
	private String hotelAddress;
	
	@Column(name = "hotelphoneno")
	private String hotelPhoneNo;
	
	@Column(name = "hotellocation")
	private String hotelLocation;
	
	@Column(name = "description")
	private String description;
	
	
	public Hotel() {
		
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
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * @param hotelName the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * @return the hotelAddress
	 */
	public String getHotelAddress() {
		return hotelAddress;
	}

	/**
	 * @param hotelAddress the hotelAddress to set
	 */
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	/**
	 * @return the hotelPhoneNo
	 */
	public String getHotelPhoneNo() {
		return hotelPhoneNo;
	}

	/**
	 * @param hotelPhoneNo the hotelPhoneNo to set
	 */
	public void setHotelPhoneNo(String hotelPhoneNo) {
		this.hotelPhoneNo = hotelPhoneNo;
	}

	/**
	 * @return the hotelLocation
	 */
	public String getHotelLocation() {
		return hotelLocation;
	}

	/**
	 * @param hotelLocation the hotelLocation to set
	 */
	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param hotelId
	 * @param hotelName
	 * @param hotelAddress
	 * @param hotelPhoneNo
	 * @param hotelLocation
	 * @param description
	 */
	public Hotel(int hotelId, String hotelName, String hotelAddress, String hotelPhoneNo, String hotelLocation,
			String description) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.hotelPhoneNo = hotelPhoneNo;
		this.hotelLocation = hotelLocation;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelAddress=" + hotelAddress
				+ ", hotelPhoneNo=" + hotelPhoneNo + ", hotelLocation=" + hotelLocation + ", description=" + description
				+ "]";
	}

	
}
