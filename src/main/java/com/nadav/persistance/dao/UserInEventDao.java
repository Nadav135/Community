package com.nadav.persistance.dao;

import com.nadav.persistance.entities.UserInEvent;

public interface UserInEventDao {
	
	public void insertUserInEvent(UserInEvent userInEvent);
	
	public void deleteUserInEvent(Integer userInEventId);
	
	public UserInEvent getUserInEventById(Integer userInEventId);

	public void updateUserInEvent(UserInEvent userInEvent);

}
