package com.anurag.sportyshoes.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.anurag.sportyshoes.entity.User;

@Controller
public class LoginController {
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
	
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model theModel)
	{
		System.out.println("register Handler Executed");
		User theUser = new User();
		theModel.addAttribute("user", theUser);
		return "registration-form";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession(false)!=null) {
			request.getSession(false).invalidate();
			return "redirect:/showMyLoginPage";
		}
		else {
			return "redirect:/showMyLoginPage";
		}
	}
	
}
