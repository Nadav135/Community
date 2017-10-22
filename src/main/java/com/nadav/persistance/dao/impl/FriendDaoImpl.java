package com.nadav.persistance.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.FriendDao;
import com.nadav.persistance.entities.Friend;

import javax.persistence.Query;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

@XmlRootElement
public class FriendDaoImpl implements FriendDao{

	final static Logger logger = Logger.getLogger(FriendDaoImpl.class);

	@Override
	public void insertFriend(Friend friend) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		friend.setCreatedAt(timestamp);
    		friend.setUpdatedAt(timestamp);
        	session.saveOrUpdate(friend);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("FriendDaoImpl,insertFriend,e: " + e);
        }
	}

	@Override
	public void deleteFriend(Integer friendId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Friend friend = session.get(Friend.class, friendId);
        	session.delete(friend);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("FriendDaoImpl,deleteFriend,e: " + e);
        }
	}

	@Override
	public Friend getFriendById(Integer friendId) {
		Friend result = new Friend();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Friend.GET_FRIEND_BY_ID);
    		query.setParameter("id", friendId);
    		List<Friend> friends = query.getResultList();
    		if(!friends.isEmpty()){
    			result = friends.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("FriendDaoImpl,getFriendById,e: " + e);
        }
        return result;
	}

	@Override
	public Friend getFriendship(Integer userId, Integer friendId) {
		Friend result = new Friend();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Friend.GET_FRIENDSHIP);
    		query.setParameter("userId", userId);
    		query.setParameter("friendId", friendId);
    		List<Friend> friends = query.getResultList();
    		if(!friends.isEmpty()){
    			result = friends.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("FriendDaoImpl,getFriendship,e: " + e);
        }
        return result;
	}
	
	@Override
	public  List<Friend> getAllRelatedFriends(Integer userId) {
		List<Friend> friendList = new ArrayList<Friend>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Friend.GET_ALL_RELATED_FRIEND);
    		query.setParameter("userId", userId);
    		List<Friend> friends = query.getResultList();
    		if(!friends.isEmpty()){
    			for (Friend fri : friends) {
    				friendList.add(fri);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("FriendDaoImpl,getAllRelatedFriends,e: " + e);
        }
        return friendList;
	}

	
	@Override
	public void updateFriend(Friend friend) {
		 try{
			SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
        	
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		friend.setUpdatedAt(timestamp);
    		session.update(friend);
        	
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("FriendDaoImpl,updateFriend,e: " + e);
        }
	}

	@Override
	public  List<Friend> getAllFriends() {
		List<Friend> friendList = new ArrayList<Friend>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Friend.GET_ALL_FRIEND);
    		List<Friend> friends = query.getResultList();
    		if(!friends.isEmpty()){
    			for (Friend fri : friends) {
    				friendList.add(fri);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("FriendDaoImpl,getAllFriends,e: " + e);
        }
        return friendList;
	}
}
