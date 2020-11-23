package com.example.daoImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.dao.ProductDao;
import com.example.model.Product;

@Repository
public class ProductDaoImpl extends JdbcDaoSupport implements ProductDao {
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public ResponseEntity<?> addProduct(String productName, String category, String size, int quanity, double price,
			String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product viewProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateProduct(String productName, String category, String size, int quanity, double price,
			String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deleteProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> viewAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> sortProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> filterProducts(String category) {
		// TODO Auto-generated method stub
		return null;
	}

}
