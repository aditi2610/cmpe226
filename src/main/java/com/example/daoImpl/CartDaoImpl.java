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

import com.example.dao.CartDao;
import com.example.mapper.CartRowMapper;
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
		SimpleJdbcCall jdbcCall = new 
				SimpleJdbcCall(dataSource).withProcedureName("updateProductInCart")
				.returningResultSet("myPro", new CartRowMapper());
		MapSqlParameterSource source = new MapSqlParameterSource();

		source.addValue("user_id_customer", userId);
		source.addValue("product_id_customer", productId);
		source.addValue("quantity_customer", quantity);
		SqlParameterSource in = source;

		Map<String, Object> out = jdbcCall.execute(in);
		List<Product> listContacts = (List<Product>) out.get("myPro");
		return new ResponseEntity<>(listContacts, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateProductInCart(int userId, int productId, int quantity) {
		SimpleJdbcCall jdbcCall = new 
				SimpleJdbcCall(dataSource).withProcedureName("updateProductInCart")
				.returningResultSet("myPro", new CartRowMapper());
		MapSqlParameterSource source = new MapSqlParameterSource();

		source.addValue("user_id_customer", userId);
		source.addValue("product_id_customer", productId);
		source.addValue("quantity_customer", quantity);
		SqlParameterSource in = source;

		Map<String, Object> out = jdbcCall.execute(in);
		List<Product> listContacts = (List<Product>) out.get("myPro");
		return new ResponseEntity<>(listContacts, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> emptyCart(int userId) {
		SimpleJdbcCall jdbcCall = new 
				SimpleJdbcCall(dataSource).withProcedureName("emptyCart");
		MapSqlParameterSource source = new MapSqlParameterSource();

		source.addValue("user_id_customer", userId);
		SqlParameterSource in = source;
				jdbcCall.execute(in);
		return new ResponseEntity<>("Cart has no elements now!", HttpStatus.OK);
	}


	@Override
	public List<Product> viewProductsInCart(int userId) {
		SimpleJdbcCall jdbcCall = new 
				SimpleJdbcCall(dataSource).withProcedureName("getAllProductsFromCart")
				.returningResultSet("cartProducts", new CartRowMapper() );
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("userId", userId);
		SqlParameterSource in = source;
		Map<String, Object> out = jdbcCall.execute(in);
		List<Product> listContacts = (List<Product>) out.get("cartProducts");
		System.out.println("## " +listContacts.toString());
		return listContacts;
	}

}
