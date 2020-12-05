package com.example.daoImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.dao.UserDao;
import com.example.model.User;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public User getUserById(int id) {
		String sql = "select * from user where user_id = ?";
		return (User) getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rwNumber) throws SQLException {
				System.out.println("Mapper:  " + rs.getString("name"));
				User emp = new User();
				emp.setUserId(rs.getInt("user_id"));
				emp.setPassword("******");
				emp.setName(rs.getString("name"));
				emp.setAddress(rs.getString("address"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setEmail(rs.getString("email"));
				emp.setTotalOrders(rs.getInt("total_orders"));
				emp.setCoupon(rs.getInt("coupon"));
				return emp;
			}
		}, new Object[] { id });
	}

	@Override
	public ResponseEntity<?> createUser(String name, int isAdmin, String address, 
			String phoneNumber, String email,
			String password) {
		System.out.println("DAO imple");
		String sql = "INSERT INTO user "
				+ "(name, is_admin, address, phone_number, email, coupon, password) VALUES"
				+ " (?, ?, ? , ? , ?, ?, MD5(?))";
		User user = new User(name, isAdmin, address, phoneNumber, email, password);
		getJdbcTemplate().update(sql, new Object[] { user.getName(), user.getIsAdmin(), user.getAddress(),
				user.getPhoneNumber(), user.getEmail(), user.getCoupon(), user.getPassword() });
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> login(String email, String password) {
	
			SimpleJdbcCall jdbcCall = new 
					SimpleJdbcCall(dataSource).withProcedureName("login");
			MapSqlParameterSource source = new MapSqlParameterSource();

			source.addValue("email_user", email);
			source.addValue("password_user", password);
			SqlParameterSource in = source;

			Map<String, Object> out = jdbcCall.execute(in);
			Boolean valid = (Boolean)out.get("validated");
			if(valid)
				
				return new ResponseEntity<>("You have logged in using "+email, HttpStatus.OK);
			else
				return new ResponseEntity<>("Password Authenticatio failed", HttpStatus.UNAUTHORIZED);
	}

}
