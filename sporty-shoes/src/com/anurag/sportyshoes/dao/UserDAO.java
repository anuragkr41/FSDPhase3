package com.anurag.sportyshoes.dao;

import java.util.List;

import com.anurag.sportyshoes.entity.User;

public interface UserDAO {

	public List<User> getUsers();

	public void saveUser(User theUser);
	
	public List<User> searchUsers(String theSearchName);
	
	public User validateLogin(String email, String password);
	
	public User getuserById(int id); 
}
