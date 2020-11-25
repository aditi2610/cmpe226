package com.example.service;

import org.springframework.http.ResponseEntity;

import com.example.model.User;

public interface UserService {

	User getUserById(int id);

	public ResponseEntity<?> createUser(String name, int isAdmin, 
		String address, String phoneNumber, String email,
		String coupon, String password);


	ResponseEntity<?> login(String email, String password);
}
