package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dao.CartDao;
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


}
