package com.example.dao;

import org.springframework.http.ResponseEntity;

public interface CartDao {

	ResponseEntity<?> addToCart(int userId, int productId, int quantity, String size, String color);
	
	ResponseEntity<?> updateProductInCart(int userId, int productId, int quantity, String size, String color);
	
	
	ResponseEntity<?> emptyCart(int userId);
	
}
