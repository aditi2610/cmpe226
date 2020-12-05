package com.example.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.Order;

public class OrderRowMapper  implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order emp = new Order();
		emp.setOrderId(rs.getInt("order_id_customer"));
		emp.setTotalPrice(rs.getDouble("total_price_customer"));
		emp.setOrderStatus(rs.getString("order_status_customer"));
		return emp;
	}

}
