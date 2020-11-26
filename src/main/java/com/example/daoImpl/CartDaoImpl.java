package com.example.daoImpl;

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

import com.example.dao.CartDao;
import com.example.mapper.OrderRowMapper;
import com.example.model.Product;

@Repository
public class CartDaoImpl extends JdbcDaoSupport implements CartDao {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired 
	DataSource dataSource;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	
	@Override
	public ResponseEntity<?> addToCart(int userId, int productId, int quantity) {
		System.out.println("Cart Dao Impl ");
		SimpleJdbcCall jdbcCall = new 
				SimpleJdbcCall(dataSource).withProcedureName("addToCart");
		MapSqlParameterSource source = new MapSqlParameterSource();

		source.addValue("user_id_customer", userId);
		source.addValue("product_id_customer", productId);
		source.addValue("quantity_customer", quantity);
		SqlParameterSource in = source;

		Map<String, Object> out = jdbcCall.execute(in);
		return new ResponseEntity<>("product successfully added to cart!", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateProductInCart(int userId, int productId, int quantity) {
		System.out.println("Cart Dao Impl ");
		SimpleJdbcCall jdbcCall = new 
				SimpleJdbcCall(dataSource).withProcedureName("updateProductInCart");
		MapSqlParameterSource source = new MapSqlParameterSource();

		source.addValue("user_id_customer", userId);
		source.addValue("product_id_customer", productId);
		source.addValue("quantity_customer", quantity);
		SqlParameterSource in = source;

		Map<String, Object> out = jdbcCall.execute(in);
		return new ResponseEntity<>("product successfully updated to cart!", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> emptyCart(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
