package com.nadav.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.ActivityDao;
import com.nadav.persistance.dao.impl.ActivityDaoImpl;
import com.nadav.persistance.entities.Activity;
import com.nadav.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {

	private final Logger log = Logger.getLogger(ActivityServiceImpl.class);
	
	private ActivityDao activityDao = new ActivityDaoImpl();
	
	public ActivityServiceImpl() {
		
	}
	
	@Override
	public void insertActivity(Activity activity) {
		activityDao.insertActivity(activity);
	}
	
	@Override
	public void deleteActivity(Integer activityId) {
		activityDao.deleteActivity(activityId);
	}
	
	@Override
	public Activity getActivityById(Integer activityId) {
		Activity activity = activityDao.getActivityById(activityId);
		return activity;
	}
	
	@Override
	public List<Activity> getActivityByName(String name){
		List<Activity> activities = activityDao.getActivityByName(name);
		return activities;
	}
	
	@Override
	public void updateActivity(Activity activity) {
		activityDao.updateActivity(activity);
	}
	
	@Override
	public List<Activity> getAllActivities(){
		List<Activity> activities = activityDao.getAllActivities();
		return activities;
	}

	public ActivityDao getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}
}
