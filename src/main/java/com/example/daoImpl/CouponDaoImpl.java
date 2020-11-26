package com.example.daoImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.dao.CouponDao;
import com.example.model.Coupon;
import com.example.model.User;

/**
 * 
 * @author aditimangal
 *
 */
@Repository
public class CouponDaoImpl extends JdbcDaoSupport implements CouponDao {

	

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired 
	DataSource dataSource;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	
	@Override
	public List<Coupon> viewAvailableCoupons(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateCoupon(List<User> list) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Coupon getCouponDetails(String couponId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResponseEntity<?> createCoupon(double value, int minOrder) {
		return null;
	}

}
