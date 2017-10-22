package com.nadav.persistance.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.EventDao;
import com.nadav.persistance.entities.Event;

import javax.persistence.Query;

import org.apache.log4j.Logger;


public class EventDaoImpl implements EventDao{

	final static Logger logger = Logger.getLogger(EventDaoImpl.class);

	@Override
	public void insertEvent(Event event) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		event.setCreatedAt(timestamp);
    		event.setUpdatedAt(timestamp);
        	session.saveOrUpdate(event);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("EventDaoImpl,insertEvent,e: " + e);
        }
	}

	@Override
	public void deleteEvent(Integer eventId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Event event = session.get(Event.class, eventId);
        	session.delete(event);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("EventDaoImpl,deleteEvent,e: " + e);
        }
	}

	@Override
	public Event getEventById(Integer eventId) {
		Event result = new Event();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Event.GET_EVENT_BY_ID);
    		query.setParameter("id", eventId);
    		List<Event> events = query.getResultList();
    		if(!events.isEmpty()){
    			result = events.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("EventDaoImpl,getEventById,e: " + e);
        }
        return result;
	}

	@Override
	public List<Event> getEventByName(String name) {
		List<Event> eventList = new ArrayList<Event>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Event.GET_ALL_EVENT_BY_NAME);
    		query.setParameter("name", "%" + name + "%");
    		List<Event> events = query.getResultList();
    		if(!events.isEmpty()){
    			for (Event eve : events) {
    				eventList.add(eve);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();        }
        catch(Exception e){
        	logger.debug("EventDaoImpl,getEventByName,e: " + e);
        }
        return eventList;
	}

	
	@Override
	public void updateEvent(Event event) {
		 try{
			SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
        	
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		event.setUpdatedAt(timestamp);
    		session.update(event);
        	
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("EventDaoImpl,updateEvent,e: " + e);
        }
	}

	@Override
	public  List<Event> getAllEvents() {
		List<Event> eventList = new ArrayList<Event>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Event.GET_ALL_EVENT);
    		List<Event> events = query.getResultList();
    		if(!events.isEmpty()){
    			for (Event eve : events) {
    				eventList.add(eve);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("EventDaoImpl,getAllEvents,e: " + e);
        }
        return eventList;
	}
}
