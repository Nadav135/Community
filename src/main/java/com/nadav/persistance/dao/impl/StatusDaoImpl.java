package com.nadav.persistance.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.StatusDao;
import com.nadav.persistance.entities.Status;

import javax.persistence.Query;

import org.apache.log4j.Logger;


public class StatusDaoImpl implements StatusDao{

	final static Logger logger = Logger.getLogger(StatusDaoImpl.class);

	@Override
	public void insertStatus(Status status) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
        	session.saveOrUpdate(status);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("StatusDaoImpl,insertStatus,e: " + e);
        }
	}

	@Override
	public void deleteStatus(Integer statusId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Status status = session.get(Status.class, statusId);
        	session.delete(status);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("StatusDaoImpl,deleteStatus,e: " + e);
        }
	}

	@Override
	public Status getStatusById(Integer statusId) {
		Status result = new Status();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Status.GET_STAUTS_BY_ID);
    		query.setParameter("id", statusId);
    		List<Status> statuses = query.getResultList();
    		if(!statuses.isEmpty()){
    			result = statuses.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("StatusDaoImpl,getStatusById,e: " + e);
        }
        return result;
	}

	@Override
	public List<Status> getStatusByName(String name) {
		List<Status> statusList = new ArrayList<Status>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Status.GET_ALL_STAUTS_BY_NAME);
    		query.setParameter("name", "%" + name + "%");
    		List<Status> statuses = query.getResultList();
    		if(!statuses.isEmpty()){
    			for (Status stat : statuses) {
    				statusList.add(stat);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("StatusDaoImpl,getStatusByName,e: " + e);
        }
        return statusList;
	}

	
	@Override
	public void updateStatus(Status status) {
		 try{
			 SessionFactory sf;
	    		sf = new Configuration().configure().buildSessionFactory();
	    		Session session = sf.openSession();
	    		Transaction trx = session.beginTransaction();
	        	
	    		session.update(status);
	        	
	    		trx.commit();
	    		session.close();
	    		sf.close();
        }
        catch(Exception e){
        	logger.debug("StatusDaoImpl,updateStatus,e: " + e);
        }
	}

	@Override
	public  List<Status> getAllStatuses() {
		List<Status> statusList = new ArrayList<Status>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Status.GET_ALL_STAUTS);
    		List<Status> statuses = query.getResultList();
    		if(!statuses.isEmpty()){
    			for (Status stat : statuses) {
    				statusList.add(stat);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("StatusDaoImpl,getAllStatuses,e: " + e);
        }
        return statusList;
	}
}
