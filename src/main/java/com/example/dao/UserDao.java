package com.example.dao;

import org.springframework.http.ResponseEntity;

import com.example.model.User;

public interface UserDao {

	User getUserById(int id);
//	public void createUser(String name, int isAdmin, String address, String email, int totalOrders, String coupon);
	ResponseEntity<?>  createUser(String name, int isAdmin, String address, int phoneNumber, String email, int totalOrders,
			String coupon);

}
