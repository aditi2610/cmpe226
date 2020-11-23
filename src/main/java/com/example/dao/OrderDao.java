package com.example.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.model.Order;
import com.example.model.Product;

/**
 * 
 * @author aditimangal
 *
 */
public interface OrderDao {
	Order viewOrder(int id);
	
	List<Order> viewOrderHistory(int id);
	
	ResponseEntity<?> createOrder(int userId);
	
	/**
	 * this is done by user and should update the status of order to cancelled
	 * @param id
	 * @return
	 */
	ResponseEntity<?> cancelOrder(int id);
	
	/**
	 * 
	 * @param userId
	 * @param orderId
	 * @param updatedStatus
	 * @return
	 */
	ResponseEntity<?> updateOrderStatus(int userId, int orderId, String updatedStatus);
}
