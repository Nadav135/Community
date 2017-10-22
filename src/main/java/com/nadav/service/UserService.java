package com.nadav.service;

import java.util.List;

import com.nadav.persistance.entities.User;

public interface UserService {

	public void insertUser(User user);
	
	public void deleteUser(Integer userId);
	
	public User getUserById(Integer userId);
	
	public List<User> getUserByName(String name);
	
	public User getUserByUsername(String username);
	
	public List<User> getUserLikeUsername(String username);
	
	public User getUserByFullname(String firsname, String lastname);
	
	public void updateUser(User user);
	
	public List<User> getAllUsers();
}
