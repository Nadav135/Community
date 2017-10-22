package com.nadav.persistance.dao;

import com.nadav.persistance.entities.UserActivity;

public interface UserActivityDao{
	
	public void insertUserActivity(UserActivity userActivity);
	
	public void deleteUserActivity(Integer userActivityId);
	
	public UserActivity getUserActivityById(Integer userActivityId);
		
	public void updateUserActivity(UserActivity userActivity);

}
