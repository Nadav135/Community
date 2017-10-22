package com.nadav.persistance.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.LikeableDao;
import com.nadav.persistance.entities.Likeable;

import javax.persistence.Query;

import org.apache.log4j.Logger;


public class LikeableDaoImpl implements LikeableDao{

	final static Logger logger = Logger.getLogger(LikeableDaoImpl.class);

	@Override
	public void insertLikeable(Likeable likeable) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		likeable.setCreatedAt(timestamp);
    		likeable.setUpdatedAt(timestamp);
        	session.saveOrUpdate(likeable);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("LikeableDaoImpl,insertLikeable,e: " + e);
        }
	}

	@Override
	public void deleteLikeable(Integer likeableId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Likeable likeable = session.get(Likeable.class, likeableId);
        	session.delete(likeable);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("LikeableDaoImpl,deleteLikeable,e: " + e);
        }
	}

	@Override
	public Likeable getLikeableById(Integer likeableId) {
		Likeable result = new Likeable();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Likeable.GET_LIKEABLE_BY_ID);
    		query.setParameter("id", likeableId);
    		List<Likeable> likeables = query.getResultList();
    		if(!likeables.isEmpty()){
    			result = likeables.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("LikeableDaoImpl,getLikeableById,e: " + e);
        }
        return result;
	}

	@Override
	public List<Likeable> getLikeableByType(String type) {
		List<Likeable> likeableList = new ArrayList<Likeable>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Likeable.GET_ALL_LIKEABLE_BY_CONTENTTYPE);
    		query.setParameter("type", "%" + type + "%");
    		List<Likeable> likeables = query.getResultList();
    		if(!likeables.isEmpty()){
    			for (Likeable like : likeables) {
    				likeableList.add(like);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();	
        }
        catch(Exception e){
        	logger.debug("LikeableDaoImpl,getLikeableByType,e: " + e);
        }
        return likeableList;
	}

	
	@Override
	public void updateLikeable(Likeable likeable) {
		 try{
			 SessionFactory sf;
	    		sf = new Configuration().configure().buildSessionFactory();
	    		Session session = sf.openSession();
	    		Transaction trx = session.beginTransaction();
	        	
	    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    		likeable.setUpdatedAt(timestamp);
	    		session.update(likeable);
	        	
	    		trx.commit();
	    		session.close();
	    		sf.close();
        }
        catch(Exception e){
        	logger.debug("LikeableDaoImpl,updateLikeable,e: " + e);
        }
	}

	@Override
	public  List<Likeable> getAllLikeables() {
		List<Likeable> likeableList = new ArrayList<Likeable>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Likeable.GET_ALL_LIKEABLE);
    		List<Likeable> likeables = query.getResultList();
    		if(!likeables.isEmpty()){
    			for (Likeable like : likeables) {
    				likeableList.add(like);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("LikeableDaoImpl,getAllLikeables,e: " + e);
        }
        return likeableList;
	}
}
