package com.anurag.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.sportyshoes.dao.ProductDAO;
import com.anurag.sportyshoes.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	//need to inject user Dao
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	@Transactional
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDAO.getProducts();
	}

	@Override
	@Transactional
	public void saveProduct(Product theProduct) {
		// TODO Auto-generated method stub
		productDAO.saveProduct(theProduct);
	}

	@Override
	@Transactional
	public Product getProduct(int theID) {
		// TODO Auto-generated method stub
		return productDAO.getCustomer(theID);
	}

	@Override
	@Transactional
	public void deleteProduct(int theId) {
		// TODO Auto-generated method stub
		productDAO.deleteProduct(theId);
	}

	@Override
	public void buyProduct(int theId) {
		// TODO Auto-generated method stub
		productDAO.buyProduct(theId);
		
	}

}
