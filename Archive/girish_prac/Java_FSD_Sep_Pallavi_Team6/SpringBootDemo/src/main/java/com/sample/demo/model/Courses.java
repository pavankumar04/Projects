package com.sample.demo.model;

public class Courses {
	private int courseId;
	private String title;
	private String description;
	
	public Courses() {
		
	}
	
	public Courses(int courseId, String title, String description) {
		this.courseId = courseId;
		this.title = title;
		this.description = description;
	}
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", title=" + title + ", description=" + description + "]";
	}
	
	
}
