package com.nadav.persistance.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.UserDao;
import com.nadav.persistance.entities.User;

import javax.persistence.Query;

import org.apache.log4j.Logger;


public class UserDaoImpl implements UserDao{

	final static Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Override
	public void insertUser(User user) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		user.setCreatedAt(timestamp);
    		user.setUpdatedAt(timestamp);
        	session.saveOrUpdate(user);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserDaoImpl,insertUser,e: " + e);
        }
	}

	@Override
	public void deleteUser(Integer userId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		User user = session.get(User.class, userId);
        	session.delete(user);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserDaoImpl,deleteUser,e: " + e);
        }
	}

	@Override
	public User getUserById(Integer userId) {
		User result = new User();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(User.GET_USER_BY_ID);
    		query.setParameter("id", userId);
    		List<User> users = query.getResultList();
    		if(!users.isEmpty()){
    			result = users.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserDaoImpl,getUserById,e: " + e);
        }
        return result;
	}

	@Override
	public List<User> getUserByName(String name) {
		List<User> userList = new ArrayList<User>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(User.GET_ALL_USER_BY_NAME);
    		query.setParameter("name", "%" + name + "%");
    		List<User> users = query.getResultList();
    		if(!users.isEmpty()){
    			for (User u : users) {
    				userList.add(u);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserDaoImpl,getUserByName,e: " + e);
        }
        return userList;
	}
	
	@Override
	public List<User> getUserLikeUsername(String username) {
		List<User> userList = new ArrayList<User>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(User.GET_USER_LIKE_USERNAME);
    		query.setParameter("username", "%" + username + "%");
    		List<User> users = query.getResultList();
    		if(!users.isEmpty()){
    			for (User u : users) {
    				userList.add(u);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserDaoImpl,getUserByName,e: " + e);
        }
        return userList;
	}
	
	@Override
	public User getUserByUsername(String username){
		User result = new User();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(User.GET_USER_BY_USERNAME);
    		query.setParameter("username", username);
    		List<User> users = query.getResultList();
    		if(!users.isEmpty()){
    			result = users.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserDaoImpl,getUserByUsername,e: " + e);
        }
        return result;
	}
	
	@Override
	public User getUserByFullname(String firsname, String lastname){
		User result = new User();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(User.GET_ALL_USER_BY_FIRSTNAME_AND_LASTNAME);
    		query.setParameter("firsname", firsname);
    		query.setParameter("lastname", lastname);
    		List<User> users = query.getResultList();
    		if(!users.isEmpty()){
    			for (User u : users) {
    				result = users.get(0);
        		}
    		}
        }
        catch(Exception e){
        	logger.debug("UserDaoImpl,getUserByFullname,e: " + e);
        }
        return result;
	}

	
	@Override
	public void updateUser(User user) {
		 try{
			SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
        	
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		user.setUpdatedAt(timestamp);
    		session.update(user);
        	
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserDaoImpl,updateUser,e: " + e);
        }
	}

	@Override
	public  List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(User.GET_ALL_USER);
    		List<User> users = query.getResultList();
    		if(!users.isEmpty()){
    			for (User u : users) {
    				userList.add(u);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("UserDaoImpl,getAllUsers,e: " + e);
        }
        return userList;
	}
}
