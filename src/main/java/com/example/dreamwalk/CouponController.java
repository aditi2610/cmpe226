package com.example.dreamwalk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Coupon;
import com.example.model.User;
import com.example.service.OrderService;

@ComponentScan("com.example") 
@RestController
public class CouponController {
	@Autowired
	OrderService orderService;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	List<Coupon> viewAvailableCoupons(int userId){
		return null;
	}
	
	void generateCoupon(List<User> list) {}
	
	
	Coupon getCouponDetails(String couponId){
		return null;
	}
}
