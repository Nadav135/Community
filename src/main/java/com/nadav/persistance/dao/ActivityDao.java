package com.nadav.persistance.dao;

import java.util.List;

import com.nadav.persistance.entities.Activity;

public interface ActivityDao {
	
	public void insertActivity(Activity activity);
	
	public void deleteActivity(Integer activityId);
	
	public Activity getActivityById(Integer activityId);
	
	public List<Activity> getActivityByName(String name);
	
	public void updateActivity(Activity activity);
	
	public List<Activity> getAllActivities();

}
