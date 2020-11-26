package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dao.CartDao;
import com.example.model.Product;
import com.example.service.CartService;
@Service("cartService")
public class CartServiceImpl implements CartService{

	@Autowired
	CartDao cartDao;
	
	@Override
	public ResponseEntity<?> addToCart(int userId, int productId, int quantity) {
		return cartDao.addToCart(userId, productId, quantity);
	}

	@Override
	public ResponseEntity<?> updateProductInCart(int userId, int productId, int quantity) {
		return cartDao.updateProductInCart(userId, productId, quantity);
	}

	@Override
	public ResponseEntity<?> emptyCart(int userId) {
		return cartDao.emptyCart(userId);
	}

	@Override
	public List<Product> viewProductsInCart(int userId) {
		return cartDao.viewProductsInCart(userId);
	}


}
