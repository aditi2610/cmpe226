package com.example.daoImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.example.dao.OrderDao;
import com.example.model.Order;

public class OrderDaoImpl extends JdbcDaoSupport implements OrderDao {

	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public Order viewOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> viewOrderHistory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createOrder(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> cancelOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateOrderStatus(int userId, int orderId, String updatedStatus) {
		// TODO Auto-generated method stub
		return null;
	}

}
