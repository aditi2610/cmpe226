package com.example.daoImpl;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.dao.CouponDao;
import com.example.mapper.CouponRowMapper;
import com.example.mapper.OrderRowMapper;
import com.example.model.Coupon;
import com.example.model.Order;

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
	public ResponseEntity<?> viewAvailableCoupons(int userId) {
		SimpleJdbcCall jdbcCall = new 
				SimpleJdbcCall(dataSource).withProcedureName("viewAvailbleCouponForUser")	
				.returningResultSet("coupons", new CouponRowMapper() );;
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("userId", userId);
		SqlParameterSource in = source;
		
		Map<String, Object> out = jdbcCall.execute(in);
		return new ResponseEntity<>(out.get("coupons"), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> generateCoupon() {
		SimpleJdbcCall jdbcCall = new 
				SimpleJdbcCall(dataSource).withProcedureName("assignCoupons");
		MapSqlParameterSource source = new MapSqlParameterSource();
		SqlParameterSource in = source;

		jdbcCall.execute(in);
		return new ResponseEntity<>("Coupons have been successfully generated", HttpStatus.OK);
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
		SimpleJdbcCall jdbcCall = new 
				SimpleJdbcCall(dataSource).withProcedureName("createCoupon");
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("couponValue", value);
		source.addValue("minOrders", minOrder);
		source.addValue("adminId", adminId);
		SqlParameterSource in = source;

		Map<String, Object> out = jdbcCall.execute(in);
		Boolean isAllowed = (Boolean)out.get("isAllowed");
		if(isAllowed == true)
			return new ResponseEntity<>(new Coupon(value, minOrder, adminId), HttpStatus.OK);
		else 
			return new ResponseEntity<>("user with givenId is not Authorized to generate Coupons. ",HttpStatus.UNAUTHORIZED);
	}

}
