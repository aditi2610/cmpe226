package com.example.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dao.CouponDao;
import com.example.model.Coupon;
import com.example.service.CouponService;

@Service("couponService")
public class CouponServiceImpl implements CouponService {

	@Autowired
	CouponDao couponDao;
	
	@Override
	public ResponseEntity<?> viewAvailableCoupons(int userId) {
		return couponDao.viewAvailableCoupons(userId);
	}

	@Override
	public ResponseEntity<?> generateCoupon() {
		return couponDao.generateCoupon();	
	}

	@Override
	public ResponseEntity<?> createCoupon(double value, int minOrder, int adminId) {
		return couponDao.createCoupon(value, minOrder, adminId);
	}

	@Override
	public Coupon getCouponDetails(int couponId) {
		return couponDao.getCouponDetails(couponId);
	}

}
