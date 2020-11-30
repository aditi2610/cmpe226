package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.model.Order;

/**
 * 
 * @author aditimangal
 *
 */
public interface OrderDao {
	
	Order viewOrder(int id);
	
	List<Order> viewOrderHistory(int id);
	
	ResponseEntity<?> createOrder(int userId) throws SQLException;
	
	/**
	 * this is done by user and should update the status of order to cancelled
	 * @param id
	 * @return
	 */
	ResponseEntity<?> cancelOrder(int user_id, int order_id);
	
	/**
	 * 
	 * @param userId
	 * @param orderId
	 * @param updatedStatus
	 * @return
	 */
	ResponseEntity<?> updateOrderStatus(int userId, int orderId, String updatedStatus);
}
