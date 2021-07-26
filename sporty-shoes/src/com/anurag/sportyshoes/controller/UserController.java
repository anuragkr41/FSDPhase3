package com.anurag.sportyshoes.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anurag.sportyshoes.dao.PurchaseDetailDAO;
import com.anurag.sportyshoes.entity.Product;
import com.anurag.sportyshoes.entity.PurchaseDetail;
import com.anurag.sportyshoes.entity.User;
import com.anurag.sportyshoes.service.ProductService;
import com.anurag.sportyshoes.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	// inject the customer service
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PurchaseDetailDAO purchaseDetailDao;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		// get customers from the service
		List<User> theUsers = userService.getUsers();

		// add the customer to the model
		theModel.addAttribute("users", theUsers);

		return "list-users";
	}

	@GetMapping("/userAddForm")
	public String userAddForm(Model theModel) {
		// Create the model attrubute to bind the data
		User theUser = new User();
		theModel.addAttribute("user", theUser);
		return "registration-form";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User theUser) {

		userService.saveUser(theUser);
		return "store";
	}

	@GetMapping("/search")
	public String searchUsers(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		// search customers from the service
		List<User> theUsers = userService.searchUsers(theSearchName);

		// add the customers to the model
		theModel.addAttribute("users", theUsers);
		return "list-users";
	}
	
	@GetMapping("/store")
	String store(Model model)
	{
		model.addAttribute("products", productService.getProducts());
		return "store";
	}

	
	  @PostMapping("/authenticateTheUser") public String authenticateTheUser(Model
	  theModel,HttpServletRequest request,HttpServletResponse response, @RequestParam("email") String email,@RequestParam("password") String password) { 
		  System.out.println("Email = "+email + " password = " + password);
		  User u=userService.validateLogin(email, password);
		  System.out.println("Received User :: "+u);
		  if(u==null) {
			  System.out.println("Invalid email or password");
			  return "redirect:/showMyLoginPage";
		  }else if(u.getUserType() == 1) {
			  System.out.println("Admin login Authenticated");
			  request.getSession(true).setAttribute("user_admin", u);
			  return "redirect:/product/list";
		  }else {
			  System.out.println("Customer login Authenticated");
			  request.getSession(true).setAttribute("user_customer", u);
			  return "redirect:/user/store";
		  }	  
	  }
	  
	  @PostMapping("/purchaseProduct")
	  public String purchaseProduct(@RequestParam ("purchaseByUserId") String userId, @RequestParam("purchaseProductId") String purchaseproductID) {
		
		  System.out.println("user ID "+userId+" purchase Product ID "+purchaseproductID);
		  Date date = new Date();
		  System.out.println(date);
		  PurchaseDetail pd1= new PurchaseDetail(Integer.parseInt(userId), Integer.parseInt(purchaseproductID), date);
		  System.out.println(pd1);
		  
		  int x = purchaseDetailDao.save(pd1);
		  System.out.println("Generated purchase Id "+x);
		  
		  return "redirect:/user/store";
	  }
	  
	  @GetMapping("/changePassword")
	  public String changePass() {
		  return "change-password-form";
	  }
	  
	  @PostMapping("/changePassword")
	  public String changePassword(Model
			  theModel,HttpServletRequest request,HttpServletResponse response, @RequestParam("new-password") String newPass, @RequestParam("confirm-password") String confirmPass) {
		  if(newPass.equals(confirmPass)) {
			  		User u =(User) request.getSession(false).getAttribute("user_admin");
			  			u.setPassword(newPass);
			  			userService.saveUser(u);
			  			System.out.println("Password Updated success");
		  }
		  return "redirect:/product/list";
	  }
	  
	  @GetMapping("/listPurchasesByDate")
	  public String listpurchasebydate(Model model)
	  {
		  System.out.println("ListPurchasessbyDate Executed");
		  List<PurchaseDetail> purchaseList = purchaseDetailDao.getAllPurchases();
		  List<User> userpurchaselist = new ArrayList<>();
		  List<Product> productpurchaselist = new ArrayList<>();
		  
		  for(PurchaseDetail pd : purchaseList)
		  {
			 User u1= userService.getuserById(pd.getPurchasedByUserID());
			 userpurchaselist.add(u1);
			 Product p1=productService.getProduct(pd.getPurchasedProductID());
			 productpurchaselist.add(p1);
		  }
		  purchaseList.forEach(pl-> {System.out.println(pl);});
		  userpurchaselist.forEach(up->{System.out.println(up);});
		  productpurchaselist.forEach(pp ->{System.out.println(pp);});
		  
		  model.addAttribute("purchaselist", purchaseList);
		  model.addAttribute("prodlist", productpurchaselist);
		  model.addAttribute("userplist", userpurchaselist);
		  
		  return "list-purchases";
	  }
	 
}