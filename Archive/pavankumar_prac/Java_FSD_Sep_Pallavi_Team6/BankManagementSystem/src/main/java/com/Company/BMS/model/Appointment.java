package com.Company.BMS.model;


import java.time.LocalDate;

public class Appointment {
	private String apptId;
	private String userId;
	private LocalDate date;
	private String description;

	public Appointment() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param apptId
	 * @param userId
	 * @param date
	 * @param description
	 */
	public Appointment(String apptId, String userId, LocalDate date, String description) {
		this.apptId = apptId;
		this.userId = userId;
		this.date = date;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Appointment [apptId=" + apptId + ", userId=" + userId + ", date=" + date + ", description="
				+ description + "]";
	}

	/**
	 * @return the apptId
	 */
	public String getApptId() {
		return apptId;
	}

	/**
	 * @param apptId the apptId to set
	 */
	public void setApptId(String apptId) {
		this.apptId = apptId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
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
	
	
	
	
	
	
	

}
