package com.nadav.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.nadav.persistance.entities.Activity;
import com.nadav.service.ActivityService;
import com.nadav.service.impl.ActivityServiceImpl;

@Path("activities")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)	
public class ActivityController {
	
	private final Logger log = Logger.getLogger(ActivityController.class);
	
    private ActivityService activityService = new ActivityServiceImpl();
    
    
    @GET
	public List<Activity> getActivities(@QueryParam("name") String name) {
    	List<Activity> activityList = new ArrayList<Activity>();
    	try {
    		if(name != null) {
    			activityList = activityService.getActivityByName(name);
    		}
    		else {
    			activityList = activityService.getAllActivities();
    		}
    	}
    	catch(Exception e){
    		log.debug("ActivityService,getActivities,e: " + e);
    	}
    	
    	return activityList;
    }
    
    
    @POST
	public void insertActivity(Activity activity) {
    	try {
    		if(activity != null) {
    			activityService.insertActivity(activity);
    		}
    	}
    	catch(Exception e){
    		log.debug("ActivityService,insertFriend,e: " + e);
    	}
    }
	

    @PUT
   	@Path("{id}")
   	public void updateActivity(@PathParam("id") Integer id, Activity activity) {
       	try {
       		if(activity != null) {
       			activity.setId(id);
       			activityService.updateActivity(activity);
       		}
       	}
       	catch(Exception e){
       		log.debug("ActivityService,updateActivity,e: " + e);
       	}
   	}
       
       
    @DELETE
   	@Path("{id}")
   	public void deleteActivity(@PathParam("id") Integer id) {
       	try {
       		activityService.deleteActivity(id);
       	}
       	catch(Exception e){
       		log.debug("ActivityService,deleteActivity,e: " + e);
       	}
   	}
       
       
    @GET
   	@Path("{id}")
    public Activity getActivityById(@PathParam("id") Integer id) {
		Activity activity = new Activity();
	   	try {
	   		activity = activityService.getActivityById(id);
	   	}
	   	catch(Exception e){
	   		log.debug("ActivityService,getActivityById,e: " + e);
	   	}
	   	
		return activity;
    }
    
    
}
