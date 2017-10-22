package com.nadav.service;

import com.nadav.persistance.entities.UserActivity;

public interface UserActivityService {

	public void insertUserActivity(UserActivity userActivity);
	
	public void deleteUserActivity(Integer userActivityId);
	
	public UserActivity getUserActivityById(Integer userActivityId);
		
	public void updateUserActivity(UserActivity userActivity);
}
