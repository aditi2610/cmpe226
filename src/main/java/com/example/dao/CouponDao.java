package com.example.dao;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.model.Coupon;
import com.example.model.User;
/**
 * 
 * @author aditimangal
 *
 */

public interface CouponDao {

	/**
	 * Customer can check the coupons he is eligible for
	 * @param userId
	 * @return
	 */
	public ResponseEntity<?> viewAvailableCoupons(int userId);
	
	/**
	 * Admin can create a coupon for all the users with value
	 * @param value is the value for this coupon
	 * @param minOrder is the minimum order required to be eligible for this coupon
	 * @return if the coupon was created successfully
	 */
//	ResponseEntity<?> createCoupon(double value, int minOrder);
	
	/**
	 * Generate the coupon for all the users based on their total orders
	 * @param list
	 * @return 
	 */
	public ResponseEntity<?> generateCoupon();
	
	/**
	 * fetch the details for a coupon
	 * @param couponId is the coupon Id
	 * @return the details of the coupon
	 */
	public Coupon getCouponDetails(int couponId);

	public ResponseEntity<?> createCoupon(double value, int minOrder, int adminId);
	
}
