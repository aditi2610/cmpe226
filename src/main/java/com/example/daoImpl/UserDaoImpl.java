package com.example.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
		String sql = "select * from user where id = ?";
		return (User) getJdbcTemplate().queryForObject(sql, new Object[] { id }, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rwNumber) throws SQLException {
				System.out.println("Mapper:  " + rs.getString("name"));
				User emp = new User();
				emp.setName(rs.getString("name"));
				return emp;
			}
		});
	}

	@Override
	public ResponseEntity<?> createUser(String name, int isAdmin, String address, String phoneNumber, String email,
			int totalOrders, String coupon) {
		System.out.println("rgher");
		String sql = "INSERT INTO user "
				+ "(name, is_admin, address, phone_number, email, total_orders, coupon) VALUES (?, ?, ? ,? , ? , ?, ?)";
		User user = new User(name, isAdmin, address, phoneNumber, email, totalOrders, coupon);
		getJdbcTemplate().update(sql, new Object[] { user.getName(), user.getIsAdmin(), user.getAddress(),
				user.getPhoneNumber(), user.getEmail(), user.getTotalOrders(), user.getCoupon() });
//		getJdbcTemplate().update(sql, new UsMa);
		return new ResponseEntity<>("New user created!", HttpStatus.CREATED);
	}

}
