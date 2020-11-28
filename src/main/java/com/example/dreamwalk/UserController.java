package com.example.dreamwalk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;


@ComponentScan("com.example") 
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value="user/{id}" , method = RequestMethod.GET)	
	public User getUser(@PathVariable("id") int id)
	{ 
		System.out.println("Reached Controller");
		return userService.getUserById(id);

	}

	// 0 is not admin 1 is admin
	@RequestMapping(value="user" , method = RequestMethod.POST)	
	public ResponseEntity<?>  createUser(
			@RequestParam(value="name",required=false) String name,
			@RequestParam(value="isAdmin",required=false) int isAdmin,
			@RequestParam(value="address",required=false) String address,
			@RequestParam(value="phoneNumber",required=false) String phoneNumber,
			@RequestParam(value="email",required=false) String email,
			@RequestParam(value="password", required = true) String password
			) 
		{ 

		return userService.createUser(name, isAdmin,address, phoneNumber, email, password);
	}

	
	@RequestMapping(value="user/login" , method = RequestMethod.POST)	
	public ResponseEntity<?> login( @RequestParam(value="email",required=true) String email, 
			@RequestParam(value="password", required = true) String password) {		
		return userService.login(email, password);
	}


}
