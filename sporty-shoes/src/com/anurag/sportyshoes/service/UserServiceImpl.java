package com.anurag.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.sportyshoes.dao.UserDAO;
import com.anurag.sportyshoes.entity.Product;
import com.anurag.sportyshoes.entity.User;

@Service
public class UserServiceImpl implements UserService {

	//need to inject user Dao
	@Autowired
	private UserDAO userDAO;
	
	
	
	
	
	@Override
	@Transactional
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDAO.getUsers();
	}





	@Override
	@Transactional
	public void saveUser(User theUser) {
		// TODO Auto-generated method stub
	
		userDAO.saveUser(theUser);
	}





	@Override
	@Transactional
	public List<User> searchUsers(String theSearchName) {
		return userDAO.searchUsers(theSearchName);
	}
	
	
	
	

}
