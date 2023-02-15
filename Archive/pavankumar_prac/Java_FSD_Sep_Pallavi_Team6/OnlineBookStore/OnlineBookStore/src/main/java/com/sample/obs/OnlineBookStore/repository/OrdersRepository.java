package com.sample.obs.OnlineBookStore.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.obs.OnlineBookStore.entity.Orders;

/**
 * Orders repository.
 * @author Pallavi Prasad
 *
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{
	public List<Orders> findByDeliveryDate(Date date);
	public List<Orders> findByOrderDate(Date date);
	
	@Query(value = "SELECT * FROM ORDERS WHERE ORDERDATE = CURDATE() AND ORDERSTATUS = 'PENDING'", nativeQuery=true)
	public List<Orders> findCurrentPendingOrders();
	
	@Query(value = "SELECT * FROM ORDERS WHERE ORDERDATE = CURDATE() AND ORDERSTATUS = 'PENDING' AND CUSTOMERID = :id", nativeQuery=true)
	public List<Orders> findPendingOrdersForCustomer(@Param("id") long id);
	
	public List<Orders> findByCustomerId(long id);
	
	@Query(value = "SELECT * FROM ORDERS ORDER BY ORDERID DESC LIMIT 1", nativeQuery=true)
	public Orders findTopByOrderByOrderIdDesc();
	
	@Modifying
	@Query(value = "UPDATE ORDERS SET ORDERSTATUS = :status WHERE ORDERID = :id", nativeQuery=true)
	public int updateOrderStatus(@Param("status") String status, @Param("id") long id);
}
