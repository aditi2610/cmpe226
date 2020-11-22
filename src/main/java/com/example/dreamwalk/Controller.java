package com.example.dreamwalk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;


@ComponentScan("com.example") 
@RestController
public class Controller {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="user/{id}" , method = RequestMethod.GET)	
	public User getUser(@PathVariable("id") int id)
	{ 
		System.out.println("Reached Controller");
		return userService.getUserById(id);
		
	}
	
	
}
