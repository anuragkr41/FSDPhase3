package com.anurag.sportyshoes.controller;

import java.util.List;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	@GetMapping("/userAddForm")
	public String userAddForm(Model theModel) {
		//Create the model attrubute to bind the data
		User theUser = new User();
		theModel.addAttribute("user",theUser); 
		return "registration-form";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User theUser) {
		
		userService.saveUser(theUser);
		return "store";
	}
	
	
	@GetMapping("/search")
    public String searchUsers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {
        // search customers from the service
        List<User> theUsers = userService.searchUsers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("users", theUsers);
        return "list-users";        
    }
	
	
	
	/*
	 * @PostMapping("/authenticateTheUser") public String authenticateTheUser(Model
	 * theModel) { return "store"; }
	 */
}