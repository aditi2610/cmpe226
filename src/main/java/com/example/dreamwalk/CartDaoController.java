package com.example.dreamwalk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Order;
import com.example.service.CartService;
import com.example.service.OrderService;

@ComponentScan("com.example") 
@RestController
public class CartDaoController {

	@Autowired
	CartService cartService;

/**
 * get Details of a particular Order
 * @param id
 * @return
 */
	@RequestMapping(value="cart" , method = RequestMethod.POST)	
	public ResponseEntity<?>  addToCart(
			@RequestParam(value="userId",required=true) int userId,
			@RequestParam(value="productId",required=true) int productId,
			@RequestParam(value="quantity",required=false) int quantity
			) 
		{ 
		System.out.println("Add TO cart");
		ResponseEntity<?> res = null;
		try {
			System.out.println("inside Cart Controller");
			res = cartService.addToCart(userId, productId, quantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	

/**
 * get Details of a particular Order
 * @param id
 * @return
 */
	@RequestMapping(value="cart" , method = RequestMethod.PUT)	
	public ResponseEntity<?>  updateCart(
			@RequestParam(value="userId",required=true) int userId,
			@RequestParam(value="productId",required=true) int productId,
			@RequestParam(value="quantity",required=false) int quantity
			) 
		{ 
		System.out.println("update cart");
		ResponseEntity<?> res = null;
		try {
			System.out.println("inside Cart Controller");
			res = cartService.updateProductInCart(userId, productId, quantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
