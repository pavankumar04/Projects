package com.sample.demo.service;

import java.util.List;

import com.sample.demo.model.Tutorial;

public interface TutorialService {
	public List<Tutorial> retrieveAllTutorials();
	public Tutorial getTutorialById(long id);
	public Tutorial saveTutorialDetails(Tutorial tutorial);
//	public Tutorial updateTutorial(Tutorial tutorial);
	public void deleteTutorialById(long id);
	public List<Tutorial> retrieveTutorialsByPublished(boolean published);
	public List<Tutorial> retrieveTutorialsByTitle(String title);
	public int updatePublishedByTutorialId(boolean published, long id);
}
