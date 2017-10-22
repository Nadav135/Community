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

import com.nadav.persistance.entities.UserInGroup;
import com.nadav.service.UserInGroupService;
import com.nadav.service.impl.UserInGroupServiceImpl;

@Path("userInGroups")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)	
public class UserInGroupController {
	
	private final Logger log = Logger.getLogger(UserInGroupController.class);
	
    private UserInGroupService userInGroupService = new UserInGroupServiceImpl();
    
    
    @POST
	public void insertUserInGroup(UserInGroup userInGroup) {
    	try {
    		if(userInGroup != null) {
    			userInGroupService.insertUserInGroup(userInGroup);
    		}
    	}
    	catch(Exception e){
    		log.debug("UserInGroupService,insertUserInGroup,e: " + e);
    	}
    }
	

    @PUT
   	@Path("{id}")
   	public void updateUserInGroup(@PathParam("id") Integer id, UserInGroup userInGroup) {
       	try {
       		if(userInGroup != null) {
       			userInGroup.setId(id);
       			userInGroupService.updateUserInGroup(userInGroup);
       		}
       	}
       	catch(Exception e){
       		log.debug("UserInGroupService,updateUserInGroup,e: " + e);
       	}
   	}
       
       
    @DELETE
   	@Path("{id}")
   	public void deleteUserInGroup(@PathParam("id") Integer id) {
       	try {
       		userInGroupService.deleteUserInGroup(id);
       	}
       	catch(Exception e){
       		log.debug("UserInGroupService,deleteUserInGroup,e: " + e);
       	}
   	}
       
       
    @GET
   	@Path("{id}")
    public UserInGroup getUserInGroupById(@PathParam("id") Integer id) {
		UserInGroup userInGroup = new UserInGroup();
	   	try {
	   		userInGroup = userInGroupService.getUserInGroupById(id);
	   	}
	   	catch(Exception e){
	   		log.debug("UserInGroupService,getUserInGroupById,e: " + e);
	   	}
	   	
		return userInGroup;
    }


}
