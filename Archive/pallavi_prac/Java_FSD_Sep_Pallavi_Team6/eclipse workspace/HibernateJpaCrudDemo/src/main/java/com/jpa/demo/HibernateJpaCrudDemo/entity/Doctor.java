package com.jpa.demo.HibernateJpaCrudDemo.entity;

import java.util.Objects;

import javax.persistence.Column;
//import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	@Id
	@Column(name = "doctor_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name = "abc", initialValue = 101)
	private int doctorId;
	
	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;
	
	@Column(name = "specialization", nullable = false)
	private String specialization;
	
//	@Embedded
//	private DoctorAddress address;
	
	public Doctor() {
		
	}

	public Doctor(String firstName, String lastName, String specialization) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialization = specialization;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", specialization=" + specialization + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(doctorId, firstName, lastName, specialization);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return doctorId == other.doctorId && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(specialization, other.specialization);
	}
}
