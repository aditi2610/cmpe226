package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	
	@Override
	public User getUserById(int id) {
		User user = userDao.getUserById(id);
		return user;
	}
	
	@Override
	public ResponseEntity<?>  createUser(String name, int isAdmin,String address, int phoneNumber, String email, int totalOrders, String coupon ) {
		return userDao.createUser(name, isAdmin, address, phoneNumber, email, totalOrders, coupon);
	}


}
