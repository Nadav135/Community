package com.nadav.service;

import com.nadav.persistance.entities.UserStatus;

public interface UserStatusService {

	public void insertUserStatus(UserStatus userStatus);
	
	public void deleteUserStatus(Integer UserStatusId);
	
	public UserStatus getUserStatusById(Integer UserStatusId);
		
	public void updateUserStatus(UserStatus userStatus);
}
