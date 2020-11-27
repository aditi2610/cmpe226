package com.example.daoImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.dao.ProductDao;
import com.example.model.Product;

@Repository
public class ProductDaoImpl extends JdbcDaoSupport implements ProductDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public ResponseEntity<?> addProduct(String productName, String category, String size, int quanity, double price,
			String color) {
		String sql = "insert into product (name, category, size, quantity, price, color) values (?,?,?,?,?,?)";
		return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			return new ResponseEntity<>(new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("category"),
					rs.getString("size"), rs.getInt("quantity"), rs.getDouble("price"), rs.getString("color")),
					HttpStatus.CREATED);
		}, new Object[] { productName, category, size, quanity, price, color });
	}

	@Override
	public Product viewProduct(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM product WHERE product_id = ?", (rs, rowNum) -> {
			return new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("category"), rs.getString("size"),
					rs.getInt("quantity"), rs.getDouble("price"), rs.getString("color"));
		}, new Object[] { id });
	}

	@Override
	public ResponseEntity<?> updateProduct(int productId, String productName, String category, String size, int quanity,
			double price, String color) {
		String sql = "update product set name=?, category=?, size=?, quantity=?, price =?,"
				+ "color=? WHERE product_id = ?";
		return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			return new ResponseEntity<>(new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("category"),
					rs.getString("size"), rs.getInt("quantity"), rs.getDouble("price"), rs.getString("color")),
					HttpStatus.CREATED);
		}, new Object[] { productName, category, size, quanity, price, color, productId });
	}

	@Override
	public ResponseEntity<?> deleteProduct(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from product where product_id=?";
		return new ResponseEntity<>(jdbcTemplate.update(sql, new Object[] { id }), HttpStatus.OK);
	}


	@Override
	public List<Product> viewAllProducts() {
		String sql = "select * from getAllProducts";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {return new Product( rs.getString("name"),
					rs.getDouble("price"));
		});
	}
	

	@Override
	public List<Product> viewAllAvailableProducts() {
		String sql = "select * from getAllAvailableProducts";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {return new Product( rs.getString("name"),
					rs.getDouble("price"));
		});
	}

	@Override
	public List<Product> sortProducts() {
		String sql = "select * from product order by price";
			return jdbcTemplate.query(sql, (rs, rowNum) -> {return new Product(rs.getString("name"), rs.getDouble("price"), rs.getString("size"));
		});
	}

	@Override
	public List<Product> filterProducts(String categßory) {
		String sql = "select * from product where category like ?";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {return new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("category"), rs.getString("size"),
					rs.getInt("quantity"), rs.getDouble("price"), rs.getString("color"));
		});
	}

}
