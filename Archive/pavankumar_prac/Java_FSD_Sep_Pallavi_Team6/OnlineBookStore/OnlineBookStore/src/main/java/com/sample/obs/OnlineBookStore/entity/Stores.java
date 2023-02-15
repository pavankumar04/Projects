package com.sample.obs.OnlineBookStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Stores class.
 * @author Pallavi Prasad
 *
 */
@Entity
@Table(name = "stores")
public class Stores {
	@Id
	@Column(name = "storeid")
	private long storeId;
	
	@Column(name = "storename")
	private String storeName;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	/**
	 * default constructor.
	 */
	public Stores() {
		
	}

	/**
	 * parameterized constructor.
	 * @param storeId long
	 * @param storeName String
	 * @param city String
	 * @param state String
	 */
	public Stores(long storeId, String storeName, String city, String state) {
		this.storeId = storeId;
		this.storeName = storeName;
		this.city = city;
		this.state = state;
	}

	/**
	 * @return the storeId
	 */
	public long getStoreId() {
		return storeId;
	}

	/**
	 * @param storeId the storeId to set
	 */
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	/**
	 * @return the storeName
	 */
	public String getStoreName() {
		return storeName;
	}

	/**
	 * @param storeName the storeName to set
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * toString method.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Stores [storeId=" + storeId + ", storeName=" + storeName + ", city=" + city + ", state=" + state + "]";
	}
}
