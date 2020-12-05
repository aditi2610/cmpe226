package com.example.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dao.OrderDao;
import com.example.model.Order;
import com.example.model.Sales;
import com.example.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	OrderDao orderDao;
	
	
	@Override
	public Order viewOrder(int id) {
		return orderDao.viewOrder(id);
	}

	@Override
	public List<Order> viewOrderHistory(int id) {
		System.out.println("inseide Order daoIMPL");
		return orderDao.viewOrderHistory(id);
	}

	@Override
	public ResponseEntity<?> createOrder(int userId) {
		return orderDao.createOrder(userId);
	}

	@Override
	public ResponseEntity<?> cancelOrder(int user_id, int order_id) {
		System.out.println("Inside Order Impl");
		return orderDao.cancelOrder(user_id, order_id);
	}

	@Override
	public ResponseEntity<?> updateOrderStatus(int userId, int orderId, String updatedStatus) {
		return orderDao.updateOrderStatus(userId, orderId, updatedStatus);
	}
	
	@Override
	public Sales monthlySale() {
		return orderDao.monthlySale();
	}
	@Override
	public Sales customerOrderHistory(int id) {
		return orderDao.customerOrderHistory(id);
	}

}
