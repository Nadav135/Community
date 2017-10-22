package com.nadav.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.UserDao;
import com.nadav.persistance.dao.impl.UserDaoImpl;
import com.nadav.persistance.entities.User;
import com.nadav.service.UserService;

public class UserServiceImpl implements UserService{

	private final Logger log = Logger.getLogger(UserServiceImpl.class);
	
	private UserDao userDao = new UserDaoImpl();
	
	public UserServiceImpl() {
		
	}


	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
		
	}

	@Override
	public void deleteUser(Integer userId) {
		userDao.deleteUser(userId);
		
	}

	@Override
	public User getUserById(Integer userId) {
		User user = userDao.getUserById(userId);
		return user;
	}

	@Override
	public List<User> getUserByName(String name) {
		List<User> users = userDao.getUserByName(name);
		return users;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = userDao.getUserByUsername(username);
		return user;
	}

	@Override
	public List<User> getUserLikeUsername(String username) {
		List<User> users = userDao.getUserLikeUsername(username);
		return users;
	}

	@Override
	public User getUserByFullname(String firsname, String lastname) {
		User user = userDao.getUserByFullname(firsname, lastname);
		return user;
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userDao.getAllUsers();
		return users;
	}

}
