package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.dao.ProductDao;
import com.example.model.Product;
import com.example.service.ProductService;

public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	
	@Override
	public ResponseEntity<?> addProduct(String productName, String category, String size, int quanity, double price,
			String color) {
		 return productDao.addProduct(productName, category, size, quanity, price, color);
	}

	@Override
	public Product viewProduct(int id) {
		return productDao.viewProduct(id);
	}

	@Override
	public ResponseEntity<?> updateProduct(String productName, String category, String size, int quanity, double price,
			String color) {
		return productDao.updateProduct(productName, category, size, quanity, price, color);
	}

	@Override
	public ResponseEntity<?> deleteProduct(int id) {
		return productDao.deleteProduct(id);
	}

	@Override
	public List<Product> viewAllProducts() {
		return productDao.viewAllProducts();
	}

	@Override
	public List<Product> sortProducts() {
		return productDao.sortProducts();
	}

	@Override
	public List<Product> filterProducts(String category) {
		return productDao.filterProducts(category);
	}

}
