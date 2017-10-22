package com.nadav.service.impl;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.UserInGroupDao;
import com.nadav.persistance.dao.impl.UserInGroupDaoImpl;
import com.nadav.persistance.entities.UserInGroup;
import com.nadav.service.UserInGroupService;

public class UserInGroupServiceImpl implements UserInGroupService{

	private final Logger log = Logger.getLogger(UserInGroupServiceImpl.class);
	
	private UserInGroupDao userInGroupDao = new UserInGroupDaoImpl();
	
	public UserInGroupServiceImpl() {
		
	}


	@Override
	public void insertUserInGroup(UserInGroup userInGroup) {
		userInGroupDao.insertUserInGroup(userInGroup);
		
	}

	@Override
	public void deleteUserInGroup(Integer UserInGroupId) {
		userInGroupDao.deleteUserInGroup(UserInGroupId);
		
	}

	@Override
	public UserInGroup getUserInGroupById(Integer UserInGroupId) {
		UserInGroup userInGroup = userInGroupDao.getUserInGroupById(UserInGroupId);
		return userInGroup;
	}

	@Override
	public void updateUserInGroup(UserInGroup userInGroup) {
		userInGroupDao.updateUserInGroup(userInGroup);
		
	}

}
