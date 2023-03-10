package com.sample.obs.OnlineBookStore.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.obs.OnlineBookStore.entity.Customer;
import com.sample.obs.OnlineBookStore.entity.Orders;
import com.sample.obs.OnlineBookStore.repository.CustomerRepository;
import com.sample.obs.OnlineBookStore.repository.OrdersRepository;
import com.sample.obs.OnlineBookStore.utils.OrderStatus;

/**
 * Service class for Orders.
 * @author Pallavi Prasad
 *
 */
@Service
public class OrdersService {
	@Autowired
	private OrdersRepository repo;
	
	@Autowired
	private CustomerRepository custRepo;
	/**
	 * to list all orders.
	 * @return list of orders
	 */
	public List<Orders> listAllOrders() {
		List<Orders> orders = repo.findAll();
		return orders;
	}
	
	/**
	 * to list orders by delivery date
	 * @param date for the delivery date
	 * @return list of orders
	 */
	public List<Orders> listAllOrdersByDeliveryDate(LocalDate date) {
		Date del = Date.valueOf(date);
		List<Orders> orders = repo.findByDeliveryDate(del);
		return orders;
	}
	
	/**
	 * list all orders by order date
	 * @param date for the order date
	 * @return list of orders
	 */
	public List<Orders> listAllOrdersByOrderDate(LocalDate date) {
		Date del = Date.valueOf(date);
		List<Orders> orders = repo.findByOrderDate(del);
		return orders;
	}
	
	/**
	 * list all pending orders for today.
	 * @return list of orders
	 */
	public List<Orders> listAllCurrentPendingOrders() {
		List<Orders> orders = repo.findCurrentPendingOrders();
		return orders;
	}
	
	/**
	 * list all today's pending orders for a customer
	 * @param id for the customer id
	 * @return list of orders
	 */
	public List<Orders> listAllCurrentPendingOrdersForCustomer(long id) {
		List<Orders> orders = repo.findPendingOrdersForCustomer(id);
		return orders;
	}
	
	/**
	 * list customer's order history.
	 * @param id for the customer id
	 * @return list of orders
	 */
	public List<Orders> listAllOrdersForCustomer(long id) {
		List<Orders> orders = repo.findByCustomerId(id);
		return orders;
	}
	
	/**
	 * to get order details
	 * @param id for the order id
	 * @return Orders object
	 */
	public Orders getOrderDetails(long id) {
		Orders order = repo.findById(id).get();
		return order;
	}
	
	/**
	 * to add new order details
	 * @param order for the Orders object
	 * @return Orders object
	 */
	public Orders saveOrder(Orders order) {
		Orders o = repo.findTopByOrderByOrderIdDesc();
		
		String stat = order.getOrderStatus().toString().toUpperCase();
		
		OrderStatus or = OrderStatus.valueOf(stat);
		
		order.setOrderStatus(or);
		
		long id = 401;
		if(o != null) {
			id = o.getOrderId() + 1;
		}
		
		order.setOrderId(id);
		
		Customer c = custRepo.findById(order.getCustomerId()).get();
		
		if(c.getWallet() > order.getAmount()) {
			o = repo.save(order);
			
			double amt = c.getWallet() - order.getAmount();
			int res = custRepo.updateWalletAmount(amt, id);
			
			if (res > 0) {
				System.out.println("Wallet Updated");
			}
		}
		
		return o;
	}
	
	/**
	 * to update the order status
	 * @param status for the order status
	 * @param id for the order id
	 * @return String
	 */
	public String updateOrderStatus(String status, long id) {
		String str = "Unable to update status";
		
		String stat = status.toUpperCase();
		
		boolean flag = false;
		
		double amt = 0;
		Orders o = repo.findById(id).get();
		
		if (o != null) {
			Customer c = custRepo.findById(o.getCustomerId()).get();
			
			for(OrderStatus or: OrderStatus.values()) {
				if(or.name().equals(stat)) {
					flag = true;
					
					if (o.getOrderStatus().compareTo(OrderStatus.PENDING) == 0) {
						if(stat.equals(OrderStatus.CANCELLED.name()) || 
								stat.equals(OrderStatus.REJECTED.name())) {
							amt = c.getWallet() + o.getAmount();
							int r = custRepo.updateWalletAmount(amt, c.getCustomerId());
							
							if (r > 0) {
								str = "Amount credited to wallet.";
							}
						}
					} else {
						flag = false;
						str = "Cannot Change status of Accepted Orders";
						break;
					}
				}
				
				if (flag) {
					int res = repo.updateOrderStatus(stat, id);
					
					if (res > 0) {
						str += " Order status updated";
					}
					break;
				}
			}
		} else {
			str = "Order not found";
		}
		
		return str;
	}
}
