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

import com.nadav.persistance.entities.Status;
import com.nadav.service.StatusService;
import com.nadav.service.impl.StatusServiceImpl;

@Path("statuses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StatusController {

	private final Logger log = Logger.getLogger(StatusController.class);
	
    private StatusService statusService = new StatusServiceImpl();
    
    
    @GET
	public List<Status> getStatuses(@QueryParam("name") String name) {
    	List<Status> statusList = new ArrayList<Status>();
    	try {
    		if(name != null) {
    			statusList = statusService.getStatusByName(name);
    		}
    		else {
    			statusList = statusService.getAllStatuses();
    		}
    	}
    	catch(Exception e){
    		log.debug("StatusService,getStatuses,e: " + e);
    	}
    	
    	return statusList;
    }
    
    
    @POST
	public void insertStatus(Status status) {
    	try {
    		if(status != null) {
    			statusService.insertStatus(status);
    		}
    	}
    	catch(Exception e){
    		log.debug("StatusService,insertStatus,e: " + e);
    	}
    }
	

    @PUT
   	@Path("{id}")
   	public void updateStatus(@PathParam("id") Integer id, Status status) {
       	try {
       		if(status != null) {
       			status.setId(id);
       			statusService.updateStatus(status);
       		}
       	}
       	catch(Exception e){
       		log.debug("StatusService,updateStatus,e: " + e);
       	}
   	}
       
       
    @DELETE
   	@Path("{id}")
   	public void deleteStatus(@PathParam("id") Integer id) {
       	try {
       		statusService.deleteStatus(id);
       	}
       	catch(Exception e){
       		log.debug("StatusService,deleteStatus,e: " + e);
       	}
   	}
       
       
    @GET
   	@Path("{id}")
    public Status getStatusById(@PathParam("id") Integer id) {
		Status status = new Status();
	   	try {
	   		status = statusService.getStatusById(id);
	   	}
	   	catch(Exception e){
	   		log.debug("StatusService,getStatusById,e: " + e);
	   	}
	   	
		return status;
    }
	
}
