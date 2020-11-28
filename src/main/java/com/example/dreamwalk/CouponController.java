package com.example.dreamwalk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Coupon;
import com.example.model.User;
import com.example.service.CouponService;

@ComponentScan("com.example") 
@RestController
public class CouponController {
	@Autowired
	CouponService couponService;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="coupon/user/{userId}" , method = RequestMethod.GET)	
	public ResponseEntity<?> viewAvailableCoupons(@PathVariable("userId") int userId){
		return couponService.viewAvailableCoupons(userId);
	}
	
	@RequestMapping(value="assignCoupon" , method = RequestMethod.GET)	
	public ResponseEntity<?> generateCoupon() {
		return couponService.generateCoupon();
	}
	
	@RequestMapping(value="coupon/{couponId}" , method = RequestMethod.GET)	
	public Coupon getCouponDetails(@PathVariable("couponId") int couponId)
	{ 
//		System.out.println("Reached Controller");
		return couponService.getCouponDetails(couponId);

	}


	@RequestMapping(value="coupon" , method = RequestMethod.POST)	
	public ResponseEntity<?>  createCoupon(
			@RequestParam(value="value",required=true) double couponValue,
			@RequestParam(value="minOrders",required=false) int minOrders,
			@RequestParam(value="adminId",required=false) int adminId
			) 
		{ 
		ResponseEntity<?> res = null;
		try {
			System.out.println("inside Controller");
			res = couponService.createCoupon(couponValue, minOrders, adminId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
