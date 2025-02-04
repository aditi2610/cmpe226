package com.example.service;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.model.Product;

public interface CartService {

	ResponseEntity<?> addToCart(int userId, int productId, int quantity);
	
	ResponseEntity<?> updateProductInCart(int userId, int productId, int quantity);
	
	
	ResponseEntity<?> emptyCart(int userId);
	public List<Product> viewProductsInCart(int userId);
}
