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

import com.nadav.persistance.entities.UserStatus;
import com.nadav.service.UserStatusService;
import com.nadav.service.impl.UserStatusServiceImpl;

@Path("userStatuses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserStatusController {
	
	private final Logger log = Logger.getLogger(UserStatusController.class);
	
    private UserStatusService userStatusService = new UserStatusServiceImpl();
    
    
    @POST
	public void insertUserStatus(UserStatus userStatus) {
    	try {
    		if(userStatus != null) {
    			userStatusService.insertUserStatus(userStatus);
    		}
    	}
    	catch(Exception e){
    		log.debug("UserStatusService,insertUserStatus,e: " + e);
    	}
    }
	

    @PUT
   	@Path("{id}")
   	public void updateUserStatus(@PathParam("id") Integer id, UserStatus userStatus) {
       	try {
       		if(userStatus != null) {
       			userStatus.setId(id);
       			userStatusService.updateUserStatus(userStatus);
       		}
       	}
       	catch(Exception e){
       		log.debug("UserStatusService,updateUserStatus,e: " + e);
       	}
   	}
       
       
    @DELETE
   	@Path("{id}")
   	public void deleteUserStatus(@PathParam("id") Integer id) {
       	try {
       		userStatusService.deleteUserStatus(id);
       	}
       	catch(Exception e){
       		log.debug("UserStatusService,deleteUserStatus,e: " + e);
       	}
   	}
       
       
    @GET
   	@Path("{id}")
    public UserStatus getUserStatusById(@PathParam("id") Integer id) {
		UserStatus userStatus = new UserStatus();
	   	try {
	   		userStatus = userStatusService.getUserStatusById(id);
	   	}
	   	catch(Exception e){
	   		log.debug("UserStatusService,getUserStatusById,e: " + e);
	   	}
	   	
		return userStatus;
    }


}
