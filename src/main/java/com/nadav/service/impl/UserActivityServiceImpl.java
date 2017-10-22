package com.nadav.service.impl;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.UserActivityDao;
import com.nadav.persistance.dao.impl.UserActivityDaoImpl;
import com.nadav.persistance.entities.UserActivity;
import com.nadav.service.UserActivityService;

public class UserActivityServiceImpl implements UserActivityService{

	private final Logger log = Logger.getLogger(UserActivityServiceImpl.class);
	
	private UserActivityDao userActivityDao = new UserActivityDaoImpl();
	
	public UserActivityServiceImpl() {
		
	}

	@Override
	public void insertUserActivity(UserActivity userActivity) {
		userActivityDao.insertUserActivity(userActivity);
		
	}

	@Override
	public void deleteUserActivity(Integer userActivityId) {
		userActivityDao.deleteUserActivity(userActivityId);
		
	}

	@Override
	public UserActivity getUserActivityById(Integer userActivityId) {
		UserActivity userActivity = userActivityDao.getUserActivityById(userActivityId);
		return userActivity;
	}

	@Override
	public void updateUserActivity(UserActivity userActivity) {
		userActivityDao. updateUserActivity(userActivity);
		
	}
}
