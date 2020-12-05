package com.example.dao;
import org.springframework.http.ResponseEntity;

import com.example.model.User;

public interface UserDao {

	User getUserById(int id);
	
	public ResponseEntity<?> createUser(String name, int isAdmin, 
		String address, String phoneNumber, String email, String password);
	
	ResponseEntity<?> login(String email, String password);
}
