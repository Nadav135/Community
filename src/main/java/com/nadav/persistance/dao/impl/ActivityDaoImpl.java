package com.nadav.persistance.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.ActivityDao;
import com.nadav.persistance.entities.Activity;

import org.apache.log4j.Logger;

public class ActivityDaoImpl implements ActivityDao {
	
	final static Logger logger = Logger.getLogger(ActivityDaoImpl.class);

	@Override
	public void insertActivity(Activity activity) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
        	session.saveOrUpdate(activity);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ActivityDaoImpl,insertActivity,e: " + e);
        }
	}

	@Override
	public void deleteActivity(Integer activityId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
        	Activity activity = getActivityById(activityId);
        	session.delete(activity);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ActivityDaoImpl,deleteActivity,e: " + e);
        }
	}

	@Override
	public Activity getActivityById(Integer activityId) {
		Activity result = new Activity();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Activity.GET_ACTIVITY_BY_ID);
    		query.setParameter("id", activityId);
    		List<Activity> activities = query.getResultList();
    		if(!activities.isEmpty()){
    			result = activities.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ActivityDaoImpl,getActivityById,e: " + e);
        }
        return result;
	}

	@Override
	public List<Activity> getActivityByName(String name) {
		List<Activity> activityList = new ArrayList<Activity>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Activity.GET_ALL_ACTIVITIES_BY_NAME);
    		query.setParameter("name", "%" + name + "%");
    		List<Activity> activities = query.getResultList();
    		if(!activities.isEmpty()){
    			for (Activity act : activities) {
        			activityList.add(act);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ActivityDaoImpl,getActivityByName,e: " + e);
        }
        return activityList;
	}

	
	@Override
	public void updateActivity(Activity activity) {
		 try{
			SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
        	
    		session.update(activity);
        	
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ActivityDaoImpl,updateActivity,e: " + e);
        }
	}

	@Override
	public List<Activity> getAllActivities() {		
		List<Activity> activityList = new ArrayList<Activity>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Activity.GET_ALL_ACTIVITIES);
    		List<Activity> activities = query.getResultList();
    		if(!activities.isEmpty()){
    			for (Activity act : activities) {
        			activityList.add(act);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ActivityDaoImpl,getAllActivities,e: " + e);
        }
        return activityList;
	}
	
}
