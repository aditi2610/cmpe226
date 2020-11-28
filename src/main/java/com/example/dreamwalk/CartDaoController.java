package com.example.dreamwalk;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CartService;

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
			){ 
		return cartService.addToCart(userId, productId, quantity);
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
			@RequestParam(value="quantity",required=true) int quantity
			) { 
		return cartService.updateProductInCart(userId, productId, quantity);
	}




	@RequestMapping(value="cart" , method = RequestMethod.DELETE)
	public ResponseEntity<?> emptyCart(@RequestParam(value="userId",required=true) int userId) {
		return cartService.emptyCart(userId);
	}
	
	
	@RequestMapping(value = "cart/{id}", method = RequestMethod.GET)
	ResponseEntity<?> viewProductsInCart(@PathVariable("id") int id) {	
		 JSONArray jsonArray = new JSONArray(cartService.viewProductsInCart(id));
		 return new ResponseEntity<>(jsonArray.toString(), HttpStatus.OK);
	}
}
