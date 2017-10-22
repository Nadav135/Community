package com.nadav.persistance.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.TopicDao;
import com.nadav.persistance.entities.Topic;

import javax.persistence.Query;

import org.apache.log4j.Logger;


public class TopicDaoImpl implements TopicDao{

	final static Logger logger = Logger.getLogger(TopicDaoImpl.class);

	@Override
	public void insertTopic(Topic topic) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		topic.setCreatedAt(timestamp);
    		topic.setUpdatedAt(timestamp);
        	session.saveOrUpdate(topic);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("TopicDaoImpl,insertTopic,e: " + e);
        }
	}

	@Override
	public void deleteTopic(Integer topicId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Topic topic = session.get(Topic.class, topicId);
        	session.delete(topic);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("TopicDaoImpl,deleteTopic,e: " + e);
        }
	}

	@Override
	public Topic getTopicById(Integer topicId) {
		Topic result = new Topic();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Topic.GET_TOPIC_BY_ID);
    		query.setParameter("id", topicId);
    		List<Topic> topics = query.getResultList();
    		if(!topics.isEmpty()){
    			result = topics.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("TopicDaoImpl,getTopicById,e: " + e);
        }
        return result;
	}

	@Override
	public List<Topic> getTopicByName(String name) {
		List<Topic> topicList = new ArrayList<Topic>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Topic.GET_ALL_TOPIC_BY_NAME);
    		query.setParameter("name", "%" + name + "%");
    		List<Topic> topics = query.getResultList();
    		if(!topics.isEmpty()){
    			for (Topic top : topics) {
    				topicList.add(top);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();

        }
        catch(Exception e){
        	logger.debug("TopicDaoImpl,getTopicByName,e: " + e);
        }
        return topicList;
	}

	
	@Override
	public void updateTopic(Topic topic) {
		 try{
			 SessionFactory sf;
	    		sf = new Configuration().configure().buildSessionFactory();
	    		Session session = sf.openSession();
	    		Transaction trx = session.beginTransaction();
	        	
	    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    		topic.setUpdatedAt(timestamp);
	    		session.update(topic);
	        	
	    		trx.commit();
	    		session.close();
	    		sf.close();
        }
        catch(Exception e){
        	logger.debug("TopicDaoImpl,updateTopic,e: " + e);
        }
	}

	@Override
	public  List<Topic> getAllTopics() {
		List<Topic> topicList = new ArrayList<Topic>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Topic.GET_ALL_TOPIC);
    		List<Topic> topics = query.getResultList();
    		if(!topics.isEmpty()){
    			for (Topic top : topics) {
    				topicList.add(top);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("TopicDaoImpl,getAllTopics,e: " + e);
        }
        return topicList;
	}
}
