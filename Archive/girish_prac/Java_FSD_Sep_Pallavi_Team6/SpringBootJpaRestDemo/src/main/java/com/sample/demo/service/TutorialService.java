package com.sample.demo.service;

import java.util.List;

//import org.springframework.data.repository.query.Param;

import com.sample.demo.model.Tutorial;

public interface TutorialService {
	public List<Tutorial> retrieveAllTutorials();
	public Tutorial getTutorialById(long id);
	public Tutorial saveTutorialDetails(Tutorial tutorial);
//	public Tutorial updateTutorial(Tutorial tutorial);
	public void deleteById(long id);
	public List<Tutorial> retrieveTutorialByPublished(boolean published);
	public List<Tutorial> retrieveTutorialByTitle(String title);
//	public int updatePublishedByTutorialId( boolean published,long id);
}