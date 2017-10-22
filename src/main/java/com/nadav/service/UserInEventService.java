package com.nadav.service;

import com.nadav.persistance.entities.UserInEvent;

public interface UserInEventService {

	public void insertUserInEvent(UserInEvent userInEvent);
	
	public void deleteUserInEvent(Integer userInEventId);
	
	public UserInEvent getUserInEventById(Integer userInEventId);
		
	public void updateUserInEvent(UserInEvent userInEvent);
}
