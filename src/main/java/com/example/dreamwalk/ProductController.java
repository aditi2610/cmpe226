package com.example.dreamwalk;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;


@ComponentScan("com.example")
@RestController
public class ProductController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	ProductService productService;
	Logger logger = LogManager.getLogger(ProductController.class);


	@RequestMapping(value = "product/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> viewProduct(@PathVariable("id") int id) {
		Product p = productService.viewProduct(id);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@RequestMapping(value = "test", method = RequestMethod.POST)
	public List<Map<String, Object>> testCreateProduct() {

//		Statement statement = getConnection().createStatement();
//		logger.atDebug();
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
	        return jdbcTemplate.queryForList("SELECT name FROM user where user_id =? ", "1");

//		System.out.println(payload);
//		return new ResponseEntity<>(payload.get(1), HttpStatus.CREATED);
	}

	@RequestMapping(value = "product", method = RequestMethod.POST)
	public ResponseEntity<?> createproduct(@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "quantity", required = false) int quantity,
			@RequestParam(value = "price", required = false) double price,
			@RequestParam(value = "color", required = false) String color) {
		ResponseEntity<?> res = null;
		try {

			res = productService.addProduct(productName, category, size, quantity, price, color);
		} catch (Exception e) {
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping(value = "product", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<?> updateProduct(@RequestBody Map<String, Object> payload) {
		int productId = (int) payload.get("productId");
		String productName = (String) payload.get("productName");
		String category = (String) payload.get("category");
		String size = (String) payload.get("size");
		int quantity =(int) payload.get("quantity");
		double price = (double) payload.get("price");
		String color = (String)  payload.get("color");
		
		return productService.updateProduct(productId, productName, category, size, quantity, price, color);
	}

	@RequestMapping(value = "product/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {
		return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "allProducts", method = RequestMethod.GET)
	public ResponseEntity<?> viewAllProducts() {
		return new ResponseEntity<>(productService.viewAllProducts(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "sortProduct", method = RequestMethod.GET)
	public ResponseEntity<?> sortProducts() {
		return new ResponseEntity<>(productService.sortProducts(), HttpStatus.OK);

	}
	
	@RequestMapping(value = "productCategory", method = RequestMethod.GET)
	public ResponseEntity<?> filterProducts(@RequestParam("category") String category) {
		return new ResponseEntity<>(productService.filterProducts(category), HttpStatus.OK);

	}
	
}
