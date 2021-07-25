package com.anurag.sportyshoes.dao;

import java.util.List;

import com.anurag.sportyshoes.entity.Product;

public interface ProductDAO {

	public List<Product> getProducts();

	public void saveProduct(Product theProduct);

	public Product getCustomer(int theID);

	public void deleteProduct(int theId);

	public void buyProduct(int theId);
}
