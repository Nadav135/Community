package com.nadav.persistance.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.UserInGroupDao;
import com.nadav.persistance.entities.UserInGroup;

public class UserInGroupDaoImpl implements UserInGroupDao {
	
	final static Logger logger = Logger.getLogger(UserInGroup.class);

	@Override
	public void insertUserInGroup(UserInGroup userInGroup) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		userInGroup.setCreatedAt(timestamp);
    		userInGroup.setUpdatedAt(timestamp);
        	session.saveOrUpdate(userInGroup);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserInGroupDaoImpl,insertUserInGroup,e: " + e);
        }
	}

	@Override
	public void deleteUserInGroup(Integer userInGroupId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		UserInGroup userGroup = session.get(UserInGroup.class, userInGroupId);
        	session.delete(userGroup);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserInGroupDaoImpl,deleteUserInGroup,e: " + e);
        }
	}

	@Override
	public UserInGroup getUserInGroupById(Integer userInGroupId) {
		UserInGroup result = new UserInGroup();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(UserInGroup.GET_USERINGROUP_BY_ID);
    		query.setParameter("id", userInGroupId);
    		List<UserInGroup> userGroups = query.getResultList();
    		System.out.println("userGroups: " + userGroups);
    		if(!userGroups.isEmpty()){
    			result = userGroups.get(0);
    		}
    		System.out.println("result: " + result);
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserInGroupDaoImpl,getUserInGroupById,e: " + e);
        }
        return result;
	}

	
	@Override
	public void updateUserInGroup(UserInGroup userInGroup) {
		 try{
			SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
        	
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		userInGroup.setUpdatedAt(timestamp);
    		session.update(userInGroup);
        	
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserInGroupDaoImpl,updateUserInGroup,e: " + e);
        }
	}

}
