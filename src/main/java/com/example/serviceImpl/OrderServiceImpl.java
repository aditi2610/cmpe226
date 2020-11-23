package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.dao.OrderDao;
import com.example.model.Order;

public class OrderServiceImpl implements OrderDao {

	
	@Autowired
	OrderDao orderDao;
	
	
	@Override
	public Order viewOrder(int id) {
		return orderDao.viewOrder(id);
	}

	@Override
	public List<Order> viewOrderHistory(int id) {
		return orderDao.viewOrderHistory(id);
	}

	@Override
	public ResponseEntity<?> createOrder(int userId) {
		return orderDao.createOrder(userId);
	}

	@Override
	public ResponseEntity<?> cancelOrder(int id) {
		return orderDao.cancelOrder(id);
	}

	@Override
	public ResponseEntity<?> updateOrderStatus(int userId, int orderId, String updatedStatus) {
		return orderDao.updateOrderStatus(userId, orderId, updatedStatus);
	}

}
