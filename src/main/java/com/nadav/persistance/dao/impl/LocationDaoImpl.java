package com.nadav.persistance.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.LocationDao;
import com.nadav.persistance.entities.Location;

import javax.persistence.Query;

import org.apache.log4j.Logger;


public class LocationDaoImpl implements LocationDao{

	final static Logger logger = Logger.getLogger(LocationDaoImpl.class);

	@Override
	public void insertLocation(Location location) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();

        	session.saveOrUpdate(location);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("LocationDaoImpl,insertLocation,e: " + e);
        }
	}

	@Override
	public void deleteLocation(Integer locationId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Location location = session.get(Location.class, locationId);
        	session.delete(location);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("LocationDaoImpl,deleteLocation,e: " + e);
        }
	}

	@Override
	public Location getLocationById(Integer locationId) {
		Location result = new Location();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Location.GET_LOCATION_BY_ID);
    		query.setParameter("id", locationId);
    		List<Location> locations = query.getResultList();
    		if(!locations.isEmpty()){
    			result = locations.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("LocationDaoImpl,getLocationById,e: " + e);
        }
        return result;
	}

	@Override
	public List<Location> getLocationByName(String name) {
		List<Location> locationList = new ArrayList<Location>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Location.GET_ALL_LOCATION_BY_NAME);
    		query.setParameter("name", "%" + name + "%");
    		List<Location> locations = query.getResultList();
    		if(!locations.isEmpty()){
    			for (Location loc : locations) {
    				locationList.add(loc);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("LocationDaoImpl,getLocationByName,e: " + e);
        }
        return locationList;
	}

	
	@Override
	public void updateLocation(Location location) {
		 try{
			 SessionFactory sf;
	    		sf = new Configuration().configure().buildSessionFactory();
	    		Session session = sf.openSession();
	    		Transaction trx = session.beginTransaction();

	    		session.update(location);
	        	
	    		trx.commit();
	    		session.close();
	    		sf.close();
        }
        catch(Exception e){
        	logger.debug("LocationDaoImpl,updateLocation,e: " + e);
        }
	}

	@Override
	public  List<Location> getAllLocations() {
		List<Location> locationList = new ArrayList<Location>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Location.GET_ALL_LOCATION);
    		List<Location> locations = query.getResultList();
    		if(!locations.isEmpty()){
    			for (Location loc : locations) {
    				locationList.add(loc);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("LocationDaoImpl,getAllLocations,e: " + e);
        }
        return locationList;
	}
}
