package com.sample.demo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.model.Tutorial;
import com.sample.demo.service.TutorialService;

@RestController
@RequestMapping("/api")
public class TutorialController {

	private TutorialService service;
	
	public TutorialController(TutorialService service) {
		this.service = service;
	}
	
	//handler methods
	@GetMapping("/tutorials")
	public ResponseEntity<List<Tutorial>> retrieveAllTutorials() {
		List<Tutorial> list = service.retrieveAllTutorials();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/tutorials/{id}")
	public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id){
		Tutorial tut = service.getTutorialById(id);
		
		if(tut == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(tut, HttpStatus.OK);
	}
	
	@PostMapping("/tutorials")
	public ResponseEntity<String> saveTutorialDetails(@RequestBody Tutorial tutorial) {
		Tutorial tut = service.saveTutorialDetails(tutorial);
		
		String str = "Unable to create tutorial";
		if (tut != null) {
			str = "Tutorial created successfully";
		}
		
		return new ResponseEntity<>(str,HttpStatus.OK);
	}
	
	@GetMapping("/tutorials/title/{title}")
	public List<Tutorial> listByTitleContaining(@PathVariable("title") String title) {
		List<Tutorial> tutorials = service.retrieveTutorialsByTitle(title);
		return tutorials;
	}
	
	@GetMapping("/tutorials/published/{published}")
	public List<Tutorial> listByPublished(@PathVariable("published") boolean published) {
		List<Tutorial> tutorials = service.retrieveTutorialsByPublished(published);
		return tutorials;
	}
	
	@Transactional
	@PutMapping("/tutorials/update/{published}/{id}")
	public ResponseEntity<String> updateTutorial(@PathVariable("published") boolean published, @PathVariable("id") long id) {
		String str = "Unable to update";
		
		int res = service.updatePublishedByTutorialId(published, id);
		
		if(res > 0) {
			str = "Tutorial updated";
		}
		
		return ResponseEntity.ok().body(str);
	}
	
	@DeleteMapping("/tutorials/delete/{id}")
	public ResponseEntity<String> deleteTutorialById(@PathVariable("id") long id) {
	
		service.deleteTutorialById(id);
		return ResponseEntity.ok().body("Tutorial Deleted");
	}
}
