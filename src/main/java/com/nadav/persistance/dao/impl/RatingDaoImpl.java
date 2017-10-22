package com.nadav.persistance.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.RatingDao;
import com.nadav.persistance.entities.Rating;

import javax.persistence.Query;

import org.apache.log4j.Logger;


public class RatingDaoImpl implements RatingDao{

	final static Logger logger = Logger.getLogger(RatingDaoImpl.class);

	@Override
	public void insertRating(Rating rating) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		rating.setCreatedAt(timestamp);
    		rating.setUpdatedAt(timestamp);
        	session.saveOrUpdate(rating);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("RatingDaoImpl,insertRating,e: " + e);
        }
	}

	@Override
	public void deleteRating(Integer ratingId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Rating rating = session.get(Rating.class, ratingId);
        	session.delete(rating);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("RatingDaoImpl,deleteRating,e: " + e);
        }
	}

	@Override
	public Rating getRatingById(Integer ratingId) {
		Rating result = new Rating();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Rating.GET_RATING_BY_ID);
    		query.setParameter("id", ratingId);
    		List<Rating> ratings = query.getResultList();
    		if(!ratings.isEmpty()){
    			result = ratings.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("RatingDaoImpl,getRatingById,e: " + e);
        }
        return result;
	}

	@Override
	public List<Rating> getRatingByValue(Integer value) {
		List<Rating> ratingList = new ArrayList<Rating>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Rating.GET_ALL_RATING_BY_VALUE);
    		query.setParameter("value", value);
    		List<Rating> ratings = query.getResultList();
    		if(!ratings.isEmpty()){
    			for (Rating rate : ratings) {
    				ratingList.add(rate);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("RatingDaoImpl,getRatingByValue,e: " + e);
        }
        return ratingList;
	}

	
	@Override
	public void updateRating(Rating rating) {
		 try{
			 SessionFactory sf;
	    		sf = new Configuration().configure().buildSessionFactory();
	    		Session session = sf.openSession();
	    		Transaction trx = session.beginTransaction();
	        	
	    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    		rating.setUpdatedAt(timestamp);
	    		session.update(rating);
	        	
	    		trx.commit();
	    		session.close();
	    		sf.close();
        }
        catch(Exception e){
        	logger.debug("RatingDaoImpl,updateRating,e: " + e);
        }
	}

	@Override
	public  List<Rating> getAllRatings() {
		List<Rating> ratingList = new ArrayList<Rating>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Rating.GET_ALL_RATING);
    		List<Rating> ratings = query.getResultList();
    		if(!ratings.isEmpty()){
    			for (Rating rate : ratings) {
    				ratingList.add(rate);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("RatingDaoImpl,getAllRatings,e: " + e);
        }
        return ratingList;
	}
}
