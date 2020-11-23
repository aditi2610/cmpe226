package com.example.service;

import org.springframework.http.ResponseEntity;

import com.example.model.User;

public interface UserService {

	User getUserById(int id);
	ResponseEntity<?>  createUser(String name, int isAdmin, String address, int phoneNumber, String email, int totalOrders,
			String coupon);
}
