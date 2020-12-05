package com.example.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User emp = new User();
		emp.setUserId(rs.getInt("user_id"));
		emp.setName(rs.getString("name"));
		emp.setAddress(rs.getString("address"));
		emp.setPhoneNumber(rs.getString("phone_number"));
		emp.setEmail(rs.getString("email"));
		emp.setTotalOrders(rs.getInt("total_orders"));
		emp.setCoupon(rs.getInt("coupon"));
		return emp;
	}

}
