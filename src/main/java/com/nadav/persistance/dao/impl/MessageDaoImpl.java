package com.nadav.persistance.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.MessageDao;
import com.nadav.persistance.entities.Message;

import javax.persistence.Query;

import org.apache.log4j.Logger;


public class MessageDaoImpl implements MessageDao{

	final static Logger logger = Logger.getLogger(MessageDaoImpl.class);

	@Override
	public void insertMessage(Message message) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		message.setCreatedAt(timestamp);
        	message.setUpdatedAt(timestamp);
        	session.saveOrUpdate(message);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("MessageDaoImpl,insertMessage,e: " + e);
        }
	}

	@Override
	public void deleteMessage(Integer messageId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Message message = session.get(Message.class, messageId);
        	session.delete(message);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("MessageDaoImpl,deleteMessage,e: " + e);
        }
	}

	@Override
	public Message getMessageById(Integer messageId) {
		Message result = new Message();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Message.GET_MESSAG_BY_ID);
    		query.setParameter("id", messageId);
    		List<Message> messages = query.getResultList();
    		if(!messages.isEmpty()){
    			result = messages.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("MessageDaoImpl,getMessageById,e: " + e);
        }
        return result;
	}

	@Override
	public List<Message> getMessageByText(String text) {
		List<Message> messageList = new ArrayList<Message>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Message.GET_ALL_MESSAG_BY_BODY);
    		query.setParameter("body", "%" + text + "%");
    		List<Message> messages = query.getResultList();
    		if(!messages.isEmpty()){
    			for (Message msg : messages) {
    				messageList.add(msg);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("MessageDaoImpl,getMessageByText,e: " + e);
        }
        return messageList;
	}

	
	@Override
	public void updateMessage(Message message) {
		 try{
			 SessionFactory sf;
	    		sf = new Configuration().configure().buildSessionFactory();
	    		Session session = sf.openSession();
	    		Transaction trx = session.beginTransaction();
	        	
	    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    		message.setUpdatedAt(timestamp);
	    		session.update(message);
	        	
	    		trx.commit();
	    		session.close();
	    		sf.close();
        }
        catch(Exception e){
        	logger.debug("MessageDaoImpl,updateMessage,e: " + e);
        }
	}

	@Override
	public  List<Message> getAllMessages() {
		List<Message> messageList = new ArrayList<Message>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Message.GET_ALL_MESSAGE);
    		List<Message> messages = query.getResultList();
    		if(!messages.isEmpty()){
    			for (Message msg : messages) {
    				messageList.add(msg);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("MessageDaoImpl,getAllMessages,e: " + e);
        }
        return messageList;
	}
}
