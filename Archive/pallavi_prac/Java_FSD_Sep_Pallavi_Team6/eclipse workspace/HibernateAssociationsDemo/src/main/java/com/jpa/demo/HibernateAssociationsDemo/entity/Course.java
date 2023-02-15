package com.jpa.demo.HibernateAssociationsDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@Column(name = "courseid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	
	@Column(name = "coursename")
	private String courseName;
	
	@Column(name = "price")
	private double price;
	
	public Course() {
		
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Course(String courseName, double price) {
		this.courseName = courseName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", price=" + price + "]";
	}
	
	
}
