package com.example.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.model.Product;

public interface CartDao {

	ResponseEntity<?> addToCart(int userId, int productId, int quantity);
	
	ResponseEntity<?> updateProductInCart(int userId, int productId, int quantity);
	
	
	ResponseEntity<?> emptyCart(int userId);
	
	List<Product> viewProductsInCart(int userId);
	
}
