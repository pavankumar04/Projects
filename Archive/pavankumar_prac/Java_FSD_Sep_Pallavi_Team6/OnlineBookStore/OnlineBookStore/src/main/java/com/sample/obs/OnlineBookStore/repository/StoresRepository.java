package com.sample.obs.OnlineBookStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.obs.OnlineBookStore.entity.Stores;

/**
 * Stores Repository.
 * @author Pallavi Prasad
 *
 */
@Repository
public interface StoresRepository extends JpaRepository<Stores, Long>{
	public List<Stores> findAllByCity(String city);
	public List<Stores> findAllByState(String state);
	public Stores findTopByOrderByStoreIdDesc();
	
	@Modifying
	@Query(value = "DELETE FROM STORES WHERE STOREID = :id", nativeQuery=true)
	public int deleteStoreById(@Param("id") long id);
}
