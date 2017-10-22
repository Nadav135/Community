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

import com.nadav.persistance.entities.UserInEvent;
import com.nadav.service.UserInEventService;
import com.nadav.service.impl.UserInEventServiceImpl;

@Path("userInEvents")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserInEventController {
	
	private final Logger log = Logger.getLogger(UserInEventController.class);
	
    private UserInEventService userInEventService = new UserInEventServiceImpl();
    
    
    @POST
	public void insertUserInEvent(UserInEvent userInEvent) {
    	try {
    		if(userInEvent != null) {
    			userInEventService.insertUserInEvent(userInEvent);
    		}
    	}
    	catch(Exception e){
    		log.debug("UserInEventService,insertUserInEvent,e: " + e);
    	}
    }
	

    @PUT
   	@Path("{id}")
   	public void updateUserInEvent(@PathParam("id") Integer id, UserInEvent userInEvent) {
       	try {
       		if(userInEvent != null) {
       			userInEvent.setId(id);
       			userInEventService.updateUserInEvent(userInEvent);
       		}
       	}
       	catch(Exception e){
       		log.debug("UserInEventService,updateUserInEvent,e: " + e);
       	}
   	}
       
       
    @DELETE
   	@Path("{id}")
   	public void deleteUserInEvent(@PathParam("id") Integer id) {
       	try {
       		userInEventService.deleteUserInEvent(id);
       	}
       	catch(Exception e){
       		log.debug("UserInEventService,deleteUserInEvent,e: " + e);
       	}
   	}
       
       
    @GET
   	@Path("{id}")
    public UserInEvent getUserInEventById(@PathParam("id") Integer id) {
		UserInEvent userInEvent = new UserInEvent();
	   	try {
	   		userInEvent = userInEventService.getUserInEventById(id);
	   	}
	   	catch(Exception e){
	   		log.debug("UserInEventService,getUserInEventById,e: " + e);
	   	}
	   	
		return userInEvent;
    }

}
