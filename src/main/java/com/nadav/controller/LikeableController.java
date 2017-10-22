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

import com.nadav.persistance.entities.Likeable;
import com.nadav.service.LikeableService;
import com.nadav.service.impl.LikeableServiceImpl;

@Path("likeables")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LikeableController {
	
	private final Logger log = Logger.getLogger(LikeableController.class);
	
    private LikeableService likeableService = new LikeableServiceImpl();
    
    
    @GET
	public List<Likeable> getLikeables(@QueryParam("type") String type) {
    	List<Likeable> likeableList = new ArrayList<Likeable>();
    	try {
    		if(type != null) {
    			likeableList = likeableService.getLikeableByType(type);
    		}
    		else {
    			likeableList = likeableService.getAllLikeables();
    		}
    	}
    	catch(Exception e){
    		log.debug("LikeableService,getLikeables,e: " + e);
    	}
    	
    	return likeableList;
    }
    
    
    @POST
	public void insertLikeable(Likeable likeable) {
    	try {
    		if(likeable != null) {
    			likeableService.insertLikeable(likeable);
    		}
    	}
    	catch(Exception e){
    		log.debug("LikeableService,insertLikeable,e: " + e);
    	}
    }
	

    @PUT
   	@Path("{id}")
   	public void updateLikeable(@PathParam("id") Integer id, Likeable likeable) {
       	try {
       		if(likeable != null) {
       			likeable.setId(id);
       			likeableService.updateLikeable(likeable);
       		}
       	}
       	catch(Exception e){
       		log.debug("LikeableService,updateLikeable,e: " + e);
       	}
   	}
       
       
    @DELETE
   	@Path("{id}")
   	public void deleteLikeable(@PathParam("id") Integer id) {
       	try {
       		likeableService.deleteLikeable(id);
       	}
       	catch(Exception e){
       		log.debug("LikeableService,deleteLikeable,e: " + e);
       	}
   	}
       
       
    @GET
   	@Path("{id}")
    public Likeable getLikeableById(@PathParam("id") Integer id) {
		Likeable likeable = new Likeable();
	   	try {
	   		likeable = likeableService.getLikeableById(id);
	   	}
	   	catch(Exception e){
	   		log.debug("LikeableService,getLikeableById,e: " + e);
	   	}
	   	
		return likeable;
    }

}
