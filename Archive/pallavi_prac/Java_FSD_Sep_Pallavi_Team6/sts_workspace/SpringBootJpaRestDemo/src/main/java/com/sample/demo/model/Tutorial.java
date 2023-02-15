package com.sample.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tutorials")
public class Tutorial {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tutorial_id")
	private long tutorialId;
	
	@Column(name="title", nullable = false)
	private String title;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="published", nullable=false)
	private boolean published;
	
	public Tutorial() {
		
	}

	public Tutorial(String title, String description, boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}

	public long getTutorialId() {
		return tutorialId;
	}

	public void setTutorialId(long tutorialId) {
		this.tutorialId = tutorialId;
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

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	@Override
	public String toString() {
		return "Tutorial [tutorialId=" + tutorialId + ", title=" + title + ", description=" + description
				+ ", published=" + published + "]";
	}
	
	
}
