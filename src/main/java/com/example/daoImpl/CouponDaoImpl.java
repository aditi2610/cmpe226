package com.example.daoImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	//TODO not sure how to implement this one
	
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
	public Coupon getCouponDetails(int couponId) {
		return jdbcTemplate.queryForObject("SELECT * FROM coupon WHERE coupon_id = ?", (rs, rowNum) -> {
			return new Coupon(rs.getInt("coupon_id"),rs.getDouble("coupon_value"), rs.getInt("min_orders"),
					rs.getInt("admin_id"));
		}, new Object[] { couponId });
	}


	@Override
	public ResponseEntity<?> createCoupon(double value, int minOrder, int adminId) {
		String sql = "insert into coupon (coupon_value, min_orders, admin_id) values (?,?,?)";
		Coupon coupon = new Coupon(value, minOrder, adminId);
		getJdbcTemplate().update(sql, new Object[] { coupon.getValue(), coupon.getMinOrders(), coupon.getAdminId() });
		return new ResponseEntity<>("New Coupon created!", HttpStatus.CREATED);
	}

}
