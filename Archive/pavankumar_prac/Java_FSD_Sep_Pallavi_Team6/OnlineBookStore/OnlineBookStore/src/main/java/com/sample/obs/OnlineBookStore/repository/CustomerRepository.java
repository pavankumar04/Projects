package com.sample.obs.OnlineBookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.obs.OnlineBookStore.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	public Customer findByEmail(String email);
	public Customer findTopByOrderByCustomerIdDesc();
	
	@Modifying
	@Query(value = "UPDATE CUSTOMER SET PASSCODE = :pass WHERE CUSTOMERID = :id", nativeQuery=true)
	public int updatePassword(@Param("pass") String pass, @Param("id") long id);
	
	@Modifying
	@Query(value = "UPDATE CUSTOMER SET PHONE = :ph WHERE CUSTOMERID = :id", nativeQuery=true)
	public int updatePhone(@Param("ph") String ph, @Param("id") long id);
	
	@Modifying
	@Query(value = "UPDATE CUSTOMER SET WALLET = :wallet WHERE CUSTOMERID = :id", nativeQuery=true)
	public int updateWalletAmount(@Param("wallet") double wallet, @Param("id") long id);
	
	@Modifying
	@Query(value="UPDATE CUSTOMER SET COUPON = :coup WHERE CUSTOMERID = :id ", nativeQuery=true)
	public int updateCoupon(@Param("id") long id, @Param("coup") String coup);
	
}
