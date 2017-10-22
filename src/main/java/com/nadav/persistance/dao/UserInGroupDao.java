package com.nadav.persistance.dao;

import com.nadav.persistance.entities.UserInGroup;

public interface UserInGroupDao {
	
	public void insertUserInGroup(UserInGroup userInGroup);
	
	public void deleteUserInGroup(Integer UserInGroupId);
	
	public UserInGroup getUserInGroupById(Integer UserInGroupId);
		
	public void updateUserInGroup(UserInGroup userInGroup);
}
