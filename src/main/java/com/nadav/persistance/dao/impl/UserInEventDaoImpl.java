package com.nadav.persistance.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.UserInEventDao;
import com.nadav.persistance.entities.UserInEvent;

import javax.persistence.Query;

public class UserInEventDaoImpl implements UserInEventDao {
	
	final static Logger logger = Logger.getLogger(UserInEvent.class);

	@Override
	public void insertUserInEvent(UserInEvent userInEvent) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		userInEvent.setCreatedAt(timestamp);
    		userInEvent.setUpdatedAt(timestamp);
        	session.saveOrUpdate(userInEvent);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserInEventDaoImpl,insertUserInEvent,e: " + e);
        }
	}

	@Override
	public void deleteUserInEvent(Integer userInEventId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		UserInEvent userEvent = session.get(UserInEvent.class, userInEventId);
        	session.delete(userEvent);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserInEventDaoImpl,deleteUserInEvent,e: " + e);
        }
	}

	@Override
	public UserInEvent getUserInEventById(Integer userInEventId) {
		UserInEvent result = new UserInEvent();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(UserInEvent.GET_USERINEVENT_BY_ID);
    		query.setParameter("id", userInEventId);
    		List<UserInEvent> userEvents = query.getResultList();
    		if(!userEvents.isEmpty()){
    			result = userEvents.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ActivityDaoImpl,getUserInEventById,e: " + e);
        }
        return result;
	}

	
	@Override
	public void updateUserInEvent(UserInEvent userInEvent) {
		 try{
			SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
        	
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		userInEvent.setUpdatedAt(timestamp);
    		session.update(userInEvent);
        	
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserInEventDaoImpl,updateUserInEvent,e: " + e);
        }
	}

}
