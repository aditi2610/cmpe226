package com.example.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

import com.example.dao.OrderDao;
import com.example.mapper.OrderRowMapper;
import com.example.model.Order;
import com.example.model.Sales;

@Repository
public class OrderDaoImpl extends JdbcDaoSupport implements OrderDao {


	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired 
	DataSource dataSource;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	@Override
	public Order viewOrder(int id) {	
		return jdbcTemplate.queryForObject("SELECT * FROM orders WHERE order_id = ?", (rs, rowNum) -> {
			return new Order(rs.getInt("order_id"), rs.getInt("user_id"), rs.getInt("total_item"),
					rs.getDouble("total_price"), rs.getString("order_status"));
		}, new Object[] { id });
	}

	@Override
	public List<Order> viewOrderHistory(int userId) {
		SimpleJdbcCall jdbcCall = new 
				SimpleJdbcCall(dataSource).withProcedureName("getAllOrdersForACustomer")
				.returningResultSet("orders", new OrderRowMapper() );
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("user_id_customer", userId);
		SqlParameterSource in = source;
		Map<String, Object> out = jdbcCall.execute(in);
		List<Order> listContacts = (List<Order>) out.get("orders");
		return listContacts;
	}

	@Override
	public ResponseEntity<?> createOrder(int userId){
		System.out.println("here!");
		Connection connection = null;
		String lock = "lock tables user write;";
		String unlock = "unlock tables;";
		try {
		    connection = DriverManager.getConnection("jdbc:mysql://dreamwalk.cxm6k5gbbru4.us-east-1.rds.amazonaws.com:3306/project2", "admin", "cmpe226kong");
		    connection.setAutoCommit(false);  
		    Statement stmt1=connection.createStatement();  
		    stmt1.execute(lock);  
		    
		    SimpleJdbcCall jdbcCall = new 
					SimpleJdbcCall(dataSource).withProcedureName("createOrder")
					.returningResultSet("orders", new OrderRowMapper() );
			MapSqlParameterSource source = new MapSqlParameterSource();
			source.addValue("user_id_customer", userId);
			SqlParameterSource in = source;
			Map<String, Object> out = jdbcCall.execute(in);
			Boolean status = (Boolean)out.get("status");
			
		    stmt1.execute(unlock);  
		    if(!status) {
				return new ResponseEntity<>((String)out.get("message"), HttpStatus.OK);
			}
		    connection.commit();

		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return new ResponseEntity<>("Order Placed Successfully!", HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<?> cancelOrder(int user_id, int order_id) {
		String orderStatus = "Cancelled";
		String sql = "update orders set order_status = ? WHERE user_id = ? and order_id = ?";

		jdbcTemplate.update(sql,orderStatus, user_id, order_id);
		System.out.println("Order has been cancelled successfully");
		return jdbcTemplate.queryForObject("select * from orders where user_id = ? and order_id = ?", (rs, rowNum) ->{
			return new ResponseEntity<>(new Order(rs.getInt("order_id"), rs.getInt("user_id"), rs.getInt("total_item"),
					rs.getDouble("total_price"), rs.getString("order_status")),
					HttpStatus.CREATED);
		}, new Object[] {user_id, order_id});

	}

	@Override
	public ResponseEntity<?> updateOrderStatus(int user_id, int order_id, String updatedStatus) {
//		System.out.println("Inside OrderDao IMPL user_id " + user_id + " order_id " + order_id);
		String sql = "update orders set order_status = ? WHERE user_id = ? and order_id = ?";

		jdbcTemplate.update(sql,updatedStatus, user_id, order_id);
		System.out.println("Order has been updated successfully");
		return jdbcTemplate.queryForObject("select * from orders where user_id = ? and order_id = ?", (rs, rowNum) ->{
			return new ResponseEntity<>(new Order(rs.getInt("order_id"), rs.getInt("user_id"), rs.getInt("total_item"),
					rs.getDouble("total_price"), rs.getString("order_status")),
					HttpStatus.CREATED);
		}, new Object[] {user_id, order_id});
	}

	//TODO create a view for this 
	@Override
	public Sales monthlySale() {
		SimpleJdbcCall jdbcCall = new 
				SimpleJdbcCall(dataSource).withProcedureName("monthlySale")
				.returningResultSet("orders", new OrderRowMapper() );
		MapSqlParameterSource source = new MapSqlParameterSource();
		SqlParameterSource in = source;
		Map<String, Object> out = jdbcCall.execute(in);
		Sales monthlySale = new Sales((int) out.get("items"), (double) out.get("price"));
		return monthlySale;
	}
	
	//TODO create a view for this 
	@Override
	public Sales customerOrderHistory(int userId) {
		SimpleJdbcCall jdbcCall = new 
				SimpleJdbcCall(dataSource).withProcedureName("salesByCustomer")
				.returningResultSet("orders", new OrderRowMapper() );
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("user_customer_id", userId);
		SqlParameterSource in = source;
		Map<String, Object> out = jdbcCall.execute(in);
		Sales monthlySale = new Sales((int) out.get("items"), (double) out.get("price"));
		return monthlySale;
	}
}
