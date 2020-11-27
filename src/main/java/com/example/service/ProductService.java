package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.model.Product;

public interface ProductService {
	ResponseEntity<?> addProduct(String productName, String category, String size, 
			int quantity,
			double price, String color);

	Product viewProduct(int id);

	ResponseEntity<?> updateProduct(int productId, String productName, String category, String size, 
			int quantity,
			double price, String color);

	ResponseEntity<?> deleteProduct(int id);


	List<Product> viewAllProducts();

	List<Product> sortProducts();


	List<Product> filterProducts(String category);

	List<Product> viewAllAvailableProducts();

}
