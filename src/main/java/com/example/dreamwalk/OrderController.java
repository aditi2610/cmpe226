package com.example.dreamwalk;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Order;
import com.example.service.OrderService;


@ComponentScan("com.example") 
@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

/**
 * get Details of a particular Order
 * @param id
 * @return
 */
	@RequestMapping(value="order/{id}" , method = RequestMethod.GET)	
	public Order getOrder(@PathVariable("id") int id)
	{ 
//		System.out.println("Reached GetOrderController");
		return orderService.viewOrder(id);

	}
	
	/**
	 * get Details of ALl the orders placed by the customer of the given Id
	 * @param id is the customer Id
	 * @return
	 */
	
	@RequestMapping(value = "orderHistory/{id}", method = RequestMethod.GET)
	ResponseEntity<?> viewOrderHistory(@PathVariable("id") int id) {	
		 JSONArray jsonArray = new JSONArray(orderService.viewOrderHistory(id));
//		 System.out.println("  " + jsonArray.toString());
		 return new ResponseEntity<>(jsonArray.toString(), HttpStatus.OK);
	}
	
	/**
	 * this is like pushing the place order button
	 * everything that is in cart would be placed as an order and 
	 * cart would be empty
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "order/{id}", method = RequestMethod.POST)
	ResponseEntity<?> createOrder(@PathVariable("id")  int userId){
		return orderService.createOrder(userId);
	}
	
	/**
	 * this should update the value of order status to cancel
	 * TODO check if the method type needs to be changed.
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "cancelOrder/{user_id}/{order_id}", method = RequestMethod.PUT)
	ResponseEntity<?> cancelOrder(@PathVariable("user_id") int userId, @PathVariable("order_id") int order_id ){
//		System.out.println("Inside  controller");
		return new ResponseEntity<>(orderService.cancelOrder(userId, order_id ), HttpStatus.OK);
	}
	/**
	 * TODO consumes needs to be fixed
	 * @param userId
	 * @param orderId
	 * @param updatedStatus
	 * @return
	 */
	@RequestMapping(value = "order", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	ResponseEntity<?> updateOrderStatus(@PathVariable("user_id") int userId, @PathVariable("order_id") int orderId, @PathVariable("order_status") String updatedStatus){
		return orderService.updateOrderStatus(userId, orderId, updatedStatus);
	}
}
