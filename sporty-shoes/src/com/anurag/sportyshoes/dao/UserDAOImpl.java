package com.anurag.sportyshoes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.sportyshoes.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public User validateLogin(String email, String password) {
		
				Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("from User where email ='"+email+"' and password='"+password+"'",User.class);
		User u1= theQuery.uniqueResult();
		return u1;
	}
	
	@Override
	public List<User> getUsers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		// create a query
		Query<User> theQuery = 
				currentSession.createQuery("from User", User.class);
		
		//execute query and get result list
		
		List<User> users = theQuery.getResultList();
		
				
				
				
		// return the results
		
		
		return users;
	}



	@Override
	public void saveUser(User theUser) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		//save the customer
		currentSession.saveOrUpdate(theUser);
		
	}



	@Override
	public List<User> searchUsers(String theSearchName) {
		// get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from User where lower(firstName) like :theName or lower(lastName) like :theName", User.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from User", User.class);            
        }
        
        // execute query and get result list
        List<User> users= theQuery.getResultList();
                
        // return the results        
        return users;
        
	}

	@Override
	@Transactional
	public User getuserById(int id) {
		sessionFactory.getCurrentSession().clear();
		return sessionFactory.getCurrentSession().createQuery("from User where id="+id, User.class).uniqueResult();
		
	}

}
