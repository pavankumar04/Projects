package com.Hexaware.HMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Hexaware.HMS.entity.Admin;

public interface AdminRepository  extends JpaRepository<Admin, Long>{
	public Admin findByEmail(String email);
    public Admin findTopByOrderByAdminIdDesc();
    
    @Modifying
    @Query(value = "UPDATE ADMIN SET PASSCODE = :pass WHERE ADMINID = :id", nativeQuery=true)
    public int updatePassword(@Param("pass") String pass, @Param("id") long id);
    
    @Modifying
    @Query(value = "UPDATE ADMIN SET EMAIL = :em WHERE ADMINID = :id", nativeQuery=true)
    public int updateEmail(@Param("em") String em, @Param("id") long id);
}
