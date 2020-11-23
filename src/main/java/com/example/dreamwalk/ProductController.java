package com.example.dreamwalk;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	ProductService productService;

	@RequestMapping(value = "product/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> viewProduct(@PathVariable("id") int id) {
		Product p = productService.viewProduct(id);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@RequestMapping(value = "testAddProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<?> createProduct(@RequestBody Map<String, Object> payload) {
		System.out.println(payload);
		return new ResponseEntity<>(payload.get(1), HttpStatus.CREATED);
	}

	@RequestMapping(value = "product", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "quantity", required = false) int quantity,
			@RequestParam(value = "price", required = false) double price,
			@RequestParam(value = "color", required = false) String color) {
		ResponseEntity<?> res = null;
		try {

			res = productService.addProduct(productName, category, size, quantity, price, color);
			res.status(HttpStatus.CREATED);
		} catch (Exception e) {
			res.status(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping(value = "updateProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<?> updateProduct(@RequestBody Map<String, Object> payload) {
		
		String productName = (String) payload.get("productName");
		String category = (String) payload.get("category");
		String size = (String) payload.get("size");
		int quantity =(int) payload.get("quanity");
		double price = (double) payload.get("price");
		String color = (String)  payload.get("color");
		
		productService.updateProduct(productName, category, size, quantity, price, color);
		return new ResponseEntity<>(payload.get(1), HttpStatus.OK);
	}

}
