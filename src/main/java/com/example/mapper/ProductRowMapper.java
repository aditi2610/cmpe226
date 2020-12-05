package com.example.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.Product;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product emp = new Product();
		emp.setProductId(rs.getInt("product_id"));
		emp.setProductName(rs.getString("name"));
		emp.setCategory(rs.getString("category"));
		emp.setSize(rs.getString("size"));
		emp.setQuantity(rs.getInt("quantity"));
		emp.setPrice(rs.getDouble("price"));
		emp.setColor(rs.getString("color"));
		return emp;
	}

}
