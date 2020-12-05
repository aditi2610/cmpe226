package com.example.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dao.ProductDao;
import com.example.model.Product;
import com.example.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	
	@Override
	public ResponseEntity<?> addProduct(String productName, String category, String size, int quantity, double price,
			String color) {
		 return productDao.addProduct(productName, category, size, quantity, price, color);
	}

	@Override
	public Product viewProduct(int id) {
		return productDao.viewProduct(id);
	}

	@Override
	public ResponseEntity<?> updateProduct(int productId, String productName, String category, String size, int quantity, double price,
			String color) {
		return productDao.updateProduct(productId, productName, category, size, quantity, price, color);
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
	public List<Product> viewAllAvailableProducts() {
		return productDao.viewAllAvailableProducts();
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
