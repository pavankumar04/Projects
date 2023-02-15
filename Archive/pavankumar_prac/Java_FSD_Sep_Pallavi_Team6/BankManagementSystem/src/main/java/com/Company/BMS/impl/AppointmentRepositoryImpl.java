package com.Company.BMS.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Company.BMS.model.Appointment;
import com.Company.BMS.repository.AppointmentRepository;

@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository{
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public List<Appointment> viewAllAppointments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment showAppointment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return 0;
	}

}
