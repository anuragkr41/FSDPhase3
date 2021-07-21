package com.anurag.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anurag.sportyshoes.dao.UserDAO;
import com.anurag.sportyshoes.entity.User;
import com.anurag.sportyshoes.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {


	// inject the customer service
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		
		//get customers from the service
		
		List<User> theUsers = userService.getUsers();
		//add the customer to the model
		
		theModel.addAttribute("users", theUsers);
		
		return "list-users";
	}
}
