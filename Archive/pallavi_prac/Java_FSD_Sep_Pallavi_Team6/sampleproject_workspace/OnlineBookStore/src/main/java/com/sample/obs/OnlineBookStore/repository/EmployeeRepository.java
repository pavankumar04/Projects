package com.sample.obs.OnlineBookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.obs.OnlineBookStore.entity.Employee;

/**
 * Employee Repository.
 * @author Pallavi Prasad
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	public Employee findByEmail(String email);
	public Employee findTopByOrderByEmployeeIdDesc();
	
	@Modifying
	@Query(value = "UPDATE EMPLOYEE SET PASSCODE = :pass WHERE EMPLOYEEID = :id", nativeQuery=true)
	public int updatePassword(@Param("pass") String pass, @Param("id") long id);
	
	@Modifying
	@Query(value = "UPDATE EMPLOYEE SET PHONE = :ph WHERE EMPLOYEEID = :id", nativeQuery=true)
	public int updatePhone(@Param("ph") String ph, @Param("id") long id);
}
