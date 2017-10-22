package com.nadav.persistance.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.TopicInEntityDao;
import com.nadav.persistance.entities.TopicInEntity;

import javax.persistence.Query;

import org.apache.log4j.Logger;


public class TopicInEntityDaoImpl implements TopicInEntityDao{

	final static Logger logger = Logger.getLogger(TopicInEntityDaoImpl.class);

	@Override
	public void insertTopicInEntity(TopicInEntity topicInEntity) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
        	session.saveOrUpdate(topicInEntity);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("TopicInEntityDaoImpl,insertTopicInEntity,e: " + e);
        }
	}

	@Override
	public void deleteTopicInEntity(Integer topicInEntityId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		TopicInEntity topicEntity = session.get(TopicInEntity.class, topicInEntityId);
        	session.delete(topicEntity);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("TopicInEntityDaoImpl,deleteTopicInEntity,e: " + e);
        }
	}

	@Override
	public TopicInEntity getTopicInEntityById(Integer topicInEntityId) {
		TopicInEntity result = new TopicInEntity();
        try{
        	BasicConfigurator.configure();
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(TopicInEntity.GET_TOPICINENTITY_BY_ID);
    		query.setParameter("id", topicInEntityId);
    		List<TopicInEntity> topicEntitys = query.getResultList();
    		if(!topicEntitys.isEmpty()){
    			result = topicEntitys.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("TopicInEntityDaoImpl,getTopicInEntityById,e: " + e);
        }
        return result;
	}

	
	@Override
	public void updateTopicInEntity(TopicInEntity topicInEntity) {
		 try{
			 SessionFactory sf;
	    		sf = new Configuration().configure().buildSessionFactory();
	    		Session session = sf.openSession();
	    		Transaction trx = session.beginTransaction();
	        	
	    		session.update(topicInEntity);
	        	
	    		trx.commit();
	    		session.close();
	    		sf.close();
        }
        catch(Exception e){
        	logger.debug("TopicInEntityDaoImpl,updateTopicInEntity,e: " + e);
        }
	}

	@Override
	public  List<TopicInEntity> getAllTopicInEntities() {
		List<TopicInEntity> TopicInEntityList = new ArrayList<TopicInEntity>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(TopicInEntity.GET_ALL_TOPICINENTITY);
    		List<TopicInEntity> topicEntitys = query.getResultList();
    		if(!topicEntitys.isEmpty()){
    			for (TopicInEntity topEnt : topicEntitys) {
    				TopicInEntityList.add(topEnt);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("TopicInEntityDaoImpl,getAllTopicInEntitys,e: " + e);
        }
        return TopicInEntityList;
	}
}
