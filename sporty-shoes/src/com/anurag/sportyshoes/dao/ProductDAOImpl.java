package com.anurag.sportyshoes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anurag.sportyshoes.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Product> getProducts() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		// create a query
		Query<Product> theQuery = 
				currentSession.createQuery("from Product", Product.class);
		
		//execute query and get result list		
		List<Product> products = theQuery.getResultList();
		
		// return the results		
		return products;
	}



	@Override
	public void saveProduct(Product theProduct) {
		// TODO Auto-generated method stub
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//save the customer
		currentSession.saveOrUpdate(theProduct);
		
	}



	@Override
	public Product getCustomer(int theID) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// now retrieve the object from database using the primary key
		Product theProduct = currentSession.get(Product.class, theID);
		return theProduct;
	}



	@Override
	public void deleteProduct(int theId) {


		// get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		// delete the object by primary key
		Query theQuery = currentSession.createQuery("delete from Product where id=:productID ");
		theQuery.setParameter("productID", theId);
		
		theQuery.executeUpdate();
		
	}



	@Override
	public void buyProduct(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		// delete the object by primary key
		
//		Query theQuery = currentSession.createQuery("update from Product")
		
	}
}
























