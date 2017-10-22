package com.nadav.service.impl;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.UserStatusDao;
import com.nadav.persistance.dao.impl.UserStatusDaoImpl;
import com.nadav.persistance.entities.UserStatus;
import com.nadav.service.UserStatusService;

public class UserStatusServiceImpl implements UserStatusService{

	private final Logger log = Logger.getLogger(UserStatusServiceImpl.class);
	
	private UserStatusDao userStatusDao = new UserStatusDaoImpl();
	
	public UserStatusServiceImpl() {
		
	}

	@Override
	public void insertUserStatus(UserStatus userStatus) {
		userStatusDao.insertUserStatus(userStatus);
		
	}

	@Override
	public void deleteUserStatus(Integer UserStatusId) {
		userStatusDao.deleteUserStatus(UserStatusId);
		
	}

	@Override
	public UserStatus getUserStatusById(Integer UserStatusId) {
		UserStatus userStatus = userStatusDao.getUserStatusById(UserStatusId);
		return userStatus;
	}

	@Override
	public void updateUserStatus(UserStatus userStatus) {
		userStatusDao.updateUserStatus(userStatus);
		
	}

}
