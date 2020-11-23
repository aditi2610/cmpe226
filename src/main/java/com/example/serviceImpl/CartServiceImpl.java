package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.dao.CartDao;
import com.example.dao.OrderDao;

public class CartServiceImpl implements CartDao{

	@Autowired
	CartDao cartDao;;
	
	@Override
	public ResponseEntity<?> addToCart(int userId, int productId, int quantity, String size, String color) {
		return cartDao.addToCart(userId, productId, quantity, size, color);
	}

	@Override
	public ResponseEntity<?> updateProductInCart(int userId, int productId, int quantity, String size, String color) {
		// TODO Auto-generated method stub
		return cartDao.updateProductInCart(userId, productId, quantity, size, color);
	}

	@Override
	public ResponseEntity<?> emptyCart(int userId) {
		return cartDao.emptyCart(userId);
	}

}
