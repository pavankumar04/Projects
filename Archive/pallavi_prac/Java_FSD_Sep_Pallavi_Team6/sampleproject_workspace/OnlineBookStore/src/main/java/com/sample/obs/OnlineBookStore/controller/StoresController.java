package com.sample.obs.OnlineBookStore.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.obs.OnlineBookStore.entity.Stores;
import com.sample.obs.OnlineBookStore.service.StoresService;

/**
 * Rest API for Stores
 * @author Pallavi Prasad
 *
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class StoresController {
	@Autowired
	private StoresService service;
	
	@GetMapping("/stores/{id}")
	public ResponseEntity<Stores> retrieveStoreById(@PathVariable("id") long id) {
		Stores s = service.getStoreById(id);
		return ResponseEntity.ok().body(s);
	}
	
	@GetMapping("/stores")
	public List<Stores> retrieveAllStores() {
		List<Stores> list = service.listAllStores();
		return list; 
	}
	
	@GetMapping("/stores/city/{city}")
	public List<Stores> retrieveStoresByCity(@PathVariable("city") String city) {
		List<Stores> list = service.listStoresByCity(city);
		return list;
	}
	
	@GetMapping("/stores/state/{state}")
	public List<Stores> retrieveStoresByState(@PathVariable("state") String state) {
		List<Stores> list = service.listStoresByState(state);
		return list;
	}
	
	@PostMapping("/stores")
	public ResponseEntity<Stores> saveStoreDetails(@RequestBody Stores store) {
		Stores s = service.saveStore(store);
		return ResponseEntity.ok().body(s);
	}
	
	@DeleteMapping("/stores/remove/{id}")
	@Transactional
	public ResponseEntity<String> removeStoreDetails(@PathVariable("id") long id) {
		String str = service.removeStore(id);
		return ResponseEntity.ok().body(str);
	}
}
