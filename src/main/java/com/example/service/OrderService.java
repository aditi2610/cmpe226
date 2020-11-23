package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.model.Order;

public interface OrderService {

	
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
