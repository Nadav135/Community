package com.nadav.service.impl;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.UserInEventDao;
import com.nadav.persistance.dao.impl.UserInEventDaoImpl;
import com.nadav.persistance.entities.UserInEvent;
import com.nadav.service.UserInEventService;

public class UserInEventServiceImpl implements UserInEventService{

	private final Logger log = Logger.getLogger(UserInEventServiceImpl.class);
	
	private UserInEventDao userInEventDao = new UserInEventDaoImpl();
	
	public UserInEventServiceImpl() {
		
	}

	@Override
	public void insertUserInEvent(UserInEvent userInEvent) {
		userInEventDao.insertUserInEvent(userInEvent);
		
	}

	@Override
	public void deleteUserInEvent(Integer userInEventId) {
		userInEventDao.deleteUserInEvent(userInEventId);
		
	}

	@Override
	public UserInEvent getUserInEventById(Integer userInEventId) {
		UserInEvent userInEvent = userInEventDao.getUserInEventById(userInEventId);
		return userInEvent;
	}

	@Override
	public void updateUserInEvent(UserInEvent userInEvent) {
		userInEventDao.updateUserInEvent(userInEvent);
		
	}

}
