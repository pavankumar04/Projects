package com.Company.BMS.repository;

import java.util.List;

import com.Company.BMS.model.Appointment;

public interface AppointmentRepository {
	public List<Appointment> viewAllAppointments();
	public Appointment showAppointment(int id);
	public int addAppointment(Appointment appointment);

}

