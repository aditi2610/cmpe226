package com.example.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.dao.UserDao;
import com.example.model.User;


@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{

	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public User getUserById(int id) {
		System.out.println("Insidde get UserDao Impl");
		String  sql = "select * from user where id = ?"; 
		return (User)getJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rwNumber) throws SQLException {
				System.out.println( "Mapper:  " +rs.getString("name"));
				User emp = new User();
				emp.setName(rs.getString("name"));
				return emp;
			}
		});
	}

	
	
}
