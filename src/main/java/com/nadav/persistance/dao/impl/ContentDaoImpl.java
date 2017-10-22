package com.nadav.persistance.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.ContentDao;
import com.nadav.persistance.entities.Content;

import javax.persistence.Query;

import org.apache.log4j.Logger;


public class ContentDaoImpl implements ContentDao{

	final static Logger logger = Logger.getLogger(ContentDaoImpl.class);

	@Override
	public void insertContent(Content content) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		content.setCreatedAt(timestamp);
    		content.setUpdatedAt(timestamp);
        	session.saveOrUpdate(content);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ContentDaoImpl,insertContent,e: " + e);
        }
	}

	@Override
	public void deleteContent(Integer contentId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Content content = session.get(Content.class, contentId);
        	session.delete(content);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ContentDaoImpl,deleteContent,e: " + e);
        }
	}

	@Override
	public Content getContentById(Integer contentId) {
		Content result = new Content();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Content.GET_CONTENT_BY_ID);
    		query.setParameter("id", contentId);
    		List<Content> contents = query.getResultList();
    		if(!contents.isEmpty()){
    			result = contents.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ContentDaoImpl,getContentById,e: " + e);
        }
        return result;
	}

	@Override
	public List<Content> getContentByTitle(String title) {
		List<Content> contentList = new ArrayList<Content>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Content.GET_ALL_CONTENT_BY_TITLE);
    		query.setParameter("title", "%" + title + "%");
    		List<Content> contents = query.getResultList();
    		if(!contents.isEmpty()){
    			for (Content con : contents) {
    				contentList.add(con);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ContentDaoImpl,getContentByTitle,e: " + e);
        }
        return contentList;
	}

	
	@Override
	public void updateContent(Content content) {
		 try{
			 SessionFactory sf;
	    		sf = new Configuration().configure().buildSessionFactory();
	    		Session session = sf.openSession();
	    		Transaction trx = session.beginTransaction();
	        	
	    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	         	content.setUpdatedAt(timestamp);
	    		session.update(content);
	        	
	    		trx.commit();
	    		session.close();
	    		sf.close();
        }
		 
        catch(Exception e){
        	logger.debug("ContentDaoImpl,insertContent,e: " + e);
        }
	}

	@Override
	public  List<Content> getAllContents() {
		List<Content> contentList = new ArrayList<Content>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Content.GET_ALL_CONTENT);
    		List<Content> contents = query.getResultList();
    		if(!contents.isEmpty()){
    			for (Content con : contents) {
    				contentList.add(con);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ContentDaoImpl,insertContent,e: " + e);
        }
        return contentList;
	}
}
