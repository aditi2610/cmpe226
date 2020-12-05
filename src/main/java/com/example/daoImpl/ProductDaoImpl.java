package com.example.daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
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
		String sql = "INSERT INTO product "
				+ "(name, category, size, quantity, price, color) VALUES"
				+ " (?, ?, ? , ? , ?, ?)";
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
		    @Override
		    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		        PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		        statement.setString(1, productName);
		        statement.setString(2, category);
		        statement.setString(3, size);
		        statement.setInt(4, quanity);
		        statement.setDouble(5, price);
		        statement.setString(6, color);
		        
		        return statement;
		    }
		}, holder);
		Product product = new Product(holder.getKey().intValue() ,productName, category, size, quanity, price, color);
		
		return new ResponseEntity<>(product, HttpStatus.CREATED);	
		
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
		

		Product product = new Product(productId, productName, category, size, quanity, price, color);
		
		
		getJdbcTemplate().update(sql, new Object[] {product.getProductName(), product.getCategory(), product.getSize(),
				product.getQuantity(),product.getPrice(), product.getColor(), productId });
		//		getJdbcTemplate().update(sql, new UsMa);
		return new ResponseEntity<>(product, HttpStatus.CREATED);	
	}

	@Override
	public ResponseEntity<?> deleteProduct(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from product where product_id=?";
		return new ResponseEntity<>(jdbcTemplate.update(sql, new Object[] { id }), HttpStatus.OK);
	}


	@Override
	public List<Product> viewAllProducts() {
		String sql = "select * from product";
	
		return jdbcTemplate.query(sql, (rs, rowNum) -> {return new Product(rs.getInt("product_id"),  rs.getString("name"),
					rs.getString("category"), rs.getString("size"), rs.getInt("quantity"),rs.getDouble("price"), rs.getString("color"));
	});
	}
	

	@Override
	public List<Product> viewAllAvailableProducts() {
		String sql = "select * from product where quantity > 0";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {return new Product(rs.getInt("product_id"),  rs.getString("name"),
				rs.getString("category"), rs.getString("size"), rs.getInt("quantity"),rs.getDouble("price"), rs.getString("color"));
	});
	}

	@Override
	public List<Product> sortProducts() {
		String sql = "select * from product order by price";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {return new Product(rs.getInt("product_id"),  rs.getString("name"),
				rs.getString("category"), rs.getString("size"), rs.getInt("quantity"),rs.getDouble("price"), rs.getString("color"));
		});
	}

	@Override
	public List<Product> filterProducts(String category) {
		String sql = "select * from product where category like ?";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {return new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("category"), rs.getString("size"),
					rs.getInt("quantity"), rs.getDouble("price"), rs.getString("color"));
		}, category);
	}

}
