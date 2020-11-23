package com.example.daoImpl;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.dao.CartDao;

@Repository
public class CartDaoImpl extends JdbcDaoSupport implements CartDao {

	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public ResponseEntity<?> addToCart(int userId, int productId, int quantity, String size, String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateProductInCart(int userId, int productId, int quantity, String size, String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> emptyCart(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
