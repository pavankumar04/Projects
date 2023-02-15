package com.Hexaware.HMS.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Hexaware.HMS.entity.Guest;


/**
 * Repository class for Guest
 * @author 1000075793
 *
 */

@Repository
public interface GuestRepository extends JpaRepository<Guest,Integer>{
    public Guest findByEmail(String email);
    public Guest findTopByOrderByGuestIdDesc();
    
    public Guest findById(int id);
    @Modifying
    @Query(value = "UPDATE GUEST SET PASSCODE = :pass WHERE GUESTID = :id", nativeQuery=true)
    public int updatePassword(@Param("pass") String pass, @Param("id") int id);
    
    @Modifying
    @Query(value = "UPDATE GUEST SET PHONE = :ph WHERE GUESTID = :id", nativeQuery=true)
    public int updatePhone(@Param("ph") String ph, @Param("id") int id);
    
    @Modifying
    @Query(value = "UPDATE GUEST SET WALLET = :wallet WHERE GUESTID = :id", nativeQuery=true)
    public int updateWalletAmount(@Param("wallet") double wallet, @Param("id") int id);
    
    @Modifying
    @Query(value = "DELETE FROM GUEST WHERE GUESTID = :id", nativeQuery=true)
    public int DeleteByGuestId(@Param("id") int id);
    
}