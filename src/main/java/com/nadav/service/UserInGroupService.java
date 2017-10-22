package com.nadav.service;

import com.nadav.persistance.entities.UserInGroup;

public interface UserInGroupService {

	public void insertUserInGroup(UserInGroup userInGroup);
	
	public void deleteUserInGroup(Integer UserInGroupId);
	
	public UserInGroup getUserInGroupById(Integer UserInGroupId);
		
	public void updateUserInGroup(UserInGroup userInGroup);
}
