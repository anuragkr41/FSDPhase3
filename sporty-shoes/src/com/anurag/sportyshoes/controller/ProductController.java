package com.anurag.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anurag.sportyshoes.dao.UserDAO;
import com.anurag.sportyshoes.entity.Product;
import com.anurag.sportyshoes.entity.User;
import com.anurag.sportyshoes.service.ProductService;
import com.anurag.sportyshoes.service.UserService;

@Controller
@RequestMapping("/product")
public class ProductController {


	// inject the customer service
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public String listProducts(Model theModel) {
		
		
		//get customers from the service
		
		List<Product> theProducts= productService.getProducts();
		//add the customer to the model
		
		theModel.addAttribute("products", theProducts);
		
		return "list-products";
	}
	
	@GetMapping("/productAddForm")
	public String productAddForm(Model theModel) {
		
		//create model attribute to bind the form data
		
		Product theProduct = new Product();
		theModel.addAttribute("product", theProduct);
		
		return "product-form";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product theProduct) {
		// save the productusing the service
		productService.saveProduct(theProduct);
		return "redirect:/product/list";
	}
	
	
}
