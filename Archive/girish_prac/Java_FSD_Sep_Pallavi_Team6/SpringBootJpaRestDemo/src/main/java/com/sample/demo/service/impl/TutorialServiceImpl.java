package com.sample.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.demo.model.Tutorial;
import com.sample.demo.repository.TutorialRepository;
import com.sample.demo.service.TutorialService;

@Service
public class TutorialServiceImpl implements TutorialService {

	private TutorialRepository repo;
	
	public TutorialServiceImpl(TutorialRepository repo) {
		this.repo = repo;
	}
	@Override
	public List<Tutorial> retrieveAllTutorials() {
		List<Tutorial> list = repo.findAll();
		return list;
	}

	@Override
	public Tutorial getTutorialById(long id) {
		Tutorial tut = repo.findById(id).get();
		return tut;
	}

	@Override
	public Tutorial saveTutorialDetails(Tutorial tutorial) {
		Tutorial tut = repo.save(tutorial);
		return tut;
	}

//	@Override
//	public Tutorial updateTutorial(Tutorial tutorial) {
//		Tutorial tut = repo.save(tutorial);
//		return tut;
//	}

	@Override
	public void deleteById(long id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<Tutorial> retrieveTutorialByPublished(boolean published) {
		List<Tutorial> list = repo.findByPublished(published);
		return list;
	}
	
	@Override
	public List<Tutorial> retrieveTutorialByTitle(String title) {
		List<Tutorial> list = repo.findByTitleContaining(title);
		return list;
	}
	
//	@Override
//	public int updatePublishedByTutorialId(boolean published, long id) {
//		int tut = repo.updatePublishedByTutorialId(published, id);
//		return tut;
//	}

}
