package com.anurag.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anurag.sportyshoes.entity.Product;
import com.anurag.sportyshoes.service.ProductService;

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
	
	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productID") int theID, Model theModel) {
		
		//get the customer from the service
		Product theProduct = productService.getProduct(theID);
		//set  customer as a model attribute to pre-populate the form
		theModel.addAttribute("product", theProduct);
		//send over to our form
		return "product-form";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productID") int theId) {
		
		//delete the product
		productService.deleteProduct(theId);
		return "redirect:/product/list";
	}
	
	@GetMapping("/buy")
	public String buyProduct(@RequestParam("productID") int theId) {
	
		// buy the product by updating the time stamp against the user id
		productService.buyProduct(theId);
		return "redirect:user/store";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
