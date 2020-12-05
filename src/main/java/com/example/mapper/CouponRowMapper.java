package com.example.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.Coupon;

public class CouponRowMapper implements RowMapper<Coupon>{

	@Override
	public Coupon mapRow(ResultSet rs, int rowNum) throws SQLException {
		Coupon coupon = new Coupon();
		coupon.setMinOrders(rs.getInt("minOrders"));
		coupon.setValue(rs.getInt("couponValue"));
		return coupon;
	}

}
