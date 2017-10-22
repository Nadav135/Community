package com.nadav.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.nadav.persistance.entities.UserActivity;
import com.nadav.service.UserActivityService;
import com.nadav.service.impl.UserActivityServiceImpl;

@Path("userActivities")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)	
public class UserActivityController {

	private final Logger log = Logger.getLogger(UserActivityController.class);
	
    private UserActivityService userActivityService = new UserActivityServiceImpl();
    
    
    @POST
	public void insertUserActivity(UserActivity userActivity) {
    	try {
    		if(userActivity != null) {
    			userActivityService.insertUserActivity(userActivity);
    		}
    	}
    	catch(Exception e){
    		log.debug("UserActivityService,insertUserActivity,e: " + e);
    	}
    }
	

    @PUT
   	@Path("{id}")
   	public void updateUserActivity(@PathParam("id") Integer id, UserActivity userActivity) {
       	try {
       		if(userActivity != null) {
       			userActivity.setId(id);
       			userActivityService.updateUserActivity(userActivity);
       		}
       	}
       	catch(Exception e){
       		log.debug("UserActivityService,updateUserActivity,e: " + e);
       	}
   	}
       
       
    @DELETE
   	@Path("{id}")
   	public void deleteUserActivity(@PathParam("id") Integer id) {
       	try {
       		userActivityService.deleteUserActivity(id);
       	}
       	catch(Exception e){
       		log.debug("UserActivityService,deleteUserActivity,e: " + e);
       	}
   	}
       
       
    @GET
   	@Path("{id}")
    public UserActivity getUserActivityById(@PathParam("id") Integer id) {
		UserActivity userActivity = new UserActivity();
	   	try {
	   		userActivity = userActivityService.getUserActivityById(id);
	   	}
	   	catch(Exception e){
	   		log.debug("UserActivityService,getUserActivityById,e: " + e);
	   	}
	   	
		return userActivity;
    }
    
    
    
}
