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

import com.nadav.persistance.entities.Group;
import com.nadav.service.GroupService;
import com.nadav.service.impl.GroupServiceImpl;

@Path("groups")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GroupController {

	private final Logger log = Logger.getLogger(GroupController.class);
	
    private GroupService groupService = new GroupServiceImpl();
    
    
    @GET
	public List<Group> getGroups(@QueryParam("name") String name) {
    	List<Group> groupList = new ArrayList<Group>();
    	try {
    		if(name != null) {
    			groupList = groupService.getGroupByName(name);
    		}
    		else {
    			groupList = groupService.getAllGroups();
    		}
    	}
    	catch(Exception e){
    		log.debug("GroupService,getGroups,e: " + e);
    	}
    	
    	return groupList;
    }
    
    
    @POST
	public void insertGroup(Group group) {
    	try {
    		if(group != null) {
    			groupService.insertGroup(group);
    		}
    	}
    	catch(Exception e){
    		log.debug("GroupService,insertGroup,e: " + e);
    	}
    }
	

    @PUT
   	@Path("{id}")
   	public void updateGroup(@PathParam("id") Integer id, Group group) {
       	try {
       		if(group != null) {
       			group.setId(id);
       			groupService.updateGroup(group);
       		}
       	}
       	catch(Exception e){
       		log.debug("GroupService,updateGroup,e: " + e);
       	}
   	}
       
       
    @DELETE
   	@Path("{id}")
   	public void deleteGroup(@PathParam("id") Integer id) {
       	try {
       		groupService.deleteGroup(id);
       	}
       	catch(Exception e){
       		log.debug("GroupService,deleteGroup,e: " + e);
       	}
   	}
       
       
    @GET
   	@Path("{id}")
    public Group getGroupById(@PathParam("id") Integer id) {
		Group group = new Group();
	   	try {
	   		group = groupService.getGroupById(id);
	   	}
	   	catch(Exception e){
	   		log.debug("GroupService,getGroupById,e: " + e);
	   	}
	   	
		return group;
    }

}
