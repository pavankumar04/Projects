package com.sample.obs.OnlineBookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.obs.OnlineBookStore.entity.Stores;
import com.sample.obs.OnlineBookStore.repository.StoresRepository;

/**
 * Service class for Stores.
 * @author Pallavi Prasad
 *
 */
@Service
public class StoresService {

	@Autowired
	private StoresRepository repo;
	
	/**
	 * to get a listing of all stores.
	 * @return list of stores
	 */
	public List<Stores> listAllStores() {
		List<Stores> list = repo.findAll();
		return list;
	}
	
	/**
	 * to get a listing of stores by city.
	 * @param city for the city - String
	 * @return list of stores
	 */
	public List<Stores> listStoresByCity(String city) {
		List<Stores> list = repo.findAllByCity(city);
		return list;
	}
	
	/**
	 * to get a listing of stores by state.
	 * @param state for the state - String
	 * @return list of stores
	 */
	public List<Stores> listStoresByState(String state) {
		List<Stores> list = repo.findAllByState(state);
		return list;
	}
	
	/**
	 * to get store details based on id.
	 * @param id for the store id - long
	 * @return Stores object
	 */
	public Stores getStoreById(long id) {
		Stores store = repo.findById(id).get();
		return store;
	}
	
	/**
	 * to add a new store.
	 * @param store for the Stores object
	 * @return Stores object
	 */
	public Stores saveStore(Stores store) {
		Stores s = repo.findTopByOrderByStoreIdDesc();
		
		long id = 301;
		if (s != null) {
			id = s.getStoreId() + 1;
		}
		
		store.setStoreId(id);
		
		s = repo.save(store);
		return s;
	}
	
	/**
	 * to delete store details.
	 * @param id for store id - long
	 */
	public String removeStore(long id) {
//		repo.deleteById(id);
		String str = "Unable to delete store details";
		int res = repo.deleteStoreById(id);
		
		if (res > 0) {
			str = "Store details have been deleted";
		}
		
		return str;
	}
}
