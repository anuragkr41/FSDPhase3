package com.anurag.sportyshoes.service;

import java.util.List;

import com.anurag.sportyshoes.entity.Product;

public interface ProductService {
	
	public List<Product> getProducts();

	public void saveProduct(Product theProduct);

	public Product getProduct(int theID);

	public void deleteProduct(int theId);

	public void buyProduct(int theId);


}
