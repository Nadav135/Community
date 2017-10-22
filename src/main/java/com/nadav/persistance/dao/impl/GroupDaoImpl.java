package com.nadav.persistance.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.GroupDao;
import com.nadav.persistance.entities.Group;

import javax.persistence.Query;

import org.apache.log4j.Logger;


public class GroupDaoImpl implements GroupDao{

	final static Logger logger = Logger.getLogger(GroupDaoImpl.class);

	@Override
	public void insertGroup(Group newGroup) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		newGroup.setCreatedAt(timestamp);
    		newGroup.setUpdatedAt(timestamp);
        	session.saveOrUpdate(newGroup);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("GroupDaoImpl,insertGroup,e: " + e);
        }
	}

	@Override
	public void deleteGroup(Integer groupId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Group group = session.get(Group.class, groupId);
        	session.delete(group);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("GroupDaoImpl,deleteGroup,e: " + e);
        }
	}

	@Override
	public Group getGroupById(Integer groupId) {
		Group result = new Group();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Group.GET_GROUP_BY_ID);
    		query.setParameter("id", groupId);
    		List<Group> groups = query.getResultList();
    		if(!groups.isEmpty()){
    			result = groups.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("GroupDaoImpl,getGroupById,e: " + e);
        }
        return result;
	}

	@Override
	public List<Group> getGroupByName(String name) {
		List<Group> groupList = new ArrayList<Group>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Group.GET_ALL_GROUP_BY_NAME);
    		query.setParameter("name", "%" + name + "%");
    		List<Group> groups = query.getResultList();
    		if(!groups.isEmpty()){
    			for (Group grp : groups) {
    				groupList.add(grp);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("GroupDaoImpl,getGroupByName,e: " + e);
        }
        return groupList;
	}

	
	@Override
	public void updateGroup(Group group) {
		 try{
			 SessionFactory sf;
	    		sf = new Configuration().configure().buildSessionFactory();
	    		Session session = sf.openSession();
	    		Transaction trx = session.beginTransaction();
	        	
	    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    		group.setUpdatedAt(timestamp);
	    		session.update(group);
	        	
	    		trx.commit();
	    		session.close();
	    		sf.close();
        }
        catch(Exception e){
        	logger.debug("GroupDaoImpl,updateGroup,e: " + e);
        }
	}

	@Override
	public  List<Group> getAllGroups() {
		List<Group> groupList = new ArrayList<Group>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Group.GET_ALL_GROUP);
    		List<Group> groups = query.getResultList();
    		if(!groups.isEmpty()){
    			for (Group grp : groups) {
    				groupList.add(grp);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("GroupDaoImpl,getAllGroups,e: " + e);
        }
        return groupList;
	}
}
