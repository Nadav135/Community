package com.nadav.persistance.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.UserStatusDao;
import com.nadav.persistance.entities.UserStatus;

import javax.persistence.Query;

import org.apache.log4j.Logger;

public class UserStatusDaoImpl implements UserStatusDao{

	final static Logger logger = Logger.getLogger(UserStatus.class);

	@Override
	public void insertUserStatus(UserStatus userStatus) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
        	session.saveOrUpdate(userStatus);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserStatusDaoImpl,insertUserStatus,e: " + e);
        }
	}

	@Override
	public void deleteUserStatus(Integer userStatusId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		UserStatus userStatus = session.get(UserStatus.class, userStatusId);
        	session.delete(userStatus);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserStatusDaoImpl,deleteUserStatus,e: " + e);
        }
	}

	@Override
	public UserStatus getUserStatusById(Integer userStatusId) {
		UserStatus result = new UserStatus();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(UserStatus.GET_USERSTATUS_BY_ID);
    		query.setParameter("id", userStatusId);
    		List<UserStatus> userStatus = query.getResultList();
    		if(!userStatus.isEmpty()){
    			result = userStatus.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserStatusDaoImpl,getUserStatusById,e: " + e);
        }
        return result;
	}

	
	@Override
	public void updateUserStatus(UserStatus userStatus) {
		 try{
			 SessionFactory sf;
	    		sf = new Configuration().configure().buildSessionFactory();
	    		Session session = sf.openSession();
	    		Transaction trx = session.beginTransaction();
	        	
	    		session.update(userStatus);
	        	
	    		trx.commit();
	    		session.close();
	    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserStatusDaoImpl,updateUserStatus,e: " + e);
        }
	}

}
