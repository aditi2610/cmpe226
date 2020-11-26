package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dao.CouponDao;
import com.example.model.Coupon;
import com.example.model.User;
import com.example.service.CouponService;

@Service("couponService")
public class CouponServiceImpl implements CouponService {

	@Autowired
	CouponDao couponDao;
	
	@Override
	public List<Coupon> viewAvailableCoupons(int userId) {
		return couponDao.viewAvailableCoupons(userId);
	}

	@Override
	public void generateCoupon(List<User> list) {
		couponDao.generateCoupon(list);	
	}

	@Override
	public ResponseEntity<?> createCoupon(double value, int minOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coupon getCouponDetails(String couponId) {
		// TODO Auto-generated method stub
		return null;
	}

}
