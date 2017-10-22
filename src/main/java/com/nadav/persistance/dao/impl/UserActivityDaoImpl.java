package com.nadav.persistance.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.UserActivityDao;
import com.nadav.persistance.entities.UserActivity;

import javax.persistence.Query;

import org.apache.log4j.Logger;

public class UserActivityDaoImpl implements UserActivityDao{
						
	final static Logger logger = Logger.getLogger(UserActivity.class);

	@Override
	public void insertUserActivity(UserActivity userActivity) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
        	session.saveOrUpdate(userActivity);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserActivityDaoImpl,insertUserActivity,e: " + e);
        }
	}

	@Override
	public void deleteUserActivity(Integer UserActivityId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		UserActivity userActivity = session.get(UserActivity.class, UserActivityId);
        	session.delete(userActivity);
        	
        	trx.commit();
    		session.close();
    		sf.close();

        }
        catch(Exception e){
        	logger.debug("UserActivityDaoImpl,deleteUserActivity,e: " + e);
        }
	}

	@Override
	public UserActivity getUserActivityById(Integer UserActivityId) {
		UserActivity result = new UserActivity();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(UserActivity.GET_USERACTIVITY_BY_ID);
    		query.setParameter("id", UserActivityId);
    		List<UserActivity> userActivities = query.getResultList();
    		if(!userActivities.isEmpty()){
    			result = userActivities.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserActivityDaoImpl,getUserActivityById,e: " + e);
        }
        return result;
	}

	
	@Override
	public void updateUserActivity(UserActivity userActivity) {
		 try{
			 SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
        	
    		session.update(userActivity);
        	
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserActivityDaoImpl,updateUserActivity,e: " + e);
        }
	}

}

