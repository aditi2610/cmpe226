package com.example.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.Product;

public class CartRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Product emp = new Product();
		emp.setCategory(rs.getString("categoryC"));
		emp.setProductId(rs.getInt("productId"));
		emp.setProductName(rs.getString("nameC"));
		emp.setSize(rs.getString("sizeC"));
		emp.setQuantity(rs.getInt("quantityC"));
		emp.setPrice(rs.getDouble("priceC"));
		emp.setColor(rs.getString("colorC"));
		return emp;
	}

}
