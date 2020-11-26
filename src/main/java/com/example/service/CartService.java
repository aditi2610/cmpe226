package com.example.service;

import org.springframework.http.ResponseEntity;

public interface CartService {

	ResponseEntity<?> addToCart(int userId, int productId, int quantity);
	
	ResponseEntity<?> updateProductInCart(int userId, int productId, int quantity);
	
	
	ResponseEntity<?> emptyCart(int userId);
}
