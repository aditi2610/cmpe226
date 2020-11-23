package com.example.service;

import org.springframework.http.ResponseEntity;

public interface CartService {

ResponseEntity<?> addToCart(int userId, int productId, int quantity, String size, String color);
	
	ResponseEntity<?> updateProductInCart(int userId, int productId, int quantity, String size, String color);
	
	
	ResponseEntity<?> emptyCart(int userId);
}
