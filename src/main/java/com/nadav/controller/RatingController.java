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

import com.nadav.persistance.entities.Rating;
import com.nadav.service.RatingService;
import com.nadav.service.impl.RatingServiceImpl;

@Path("ratings")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RatingController {

	private final Logger log = Logger.getLogger(RatingController.class);
	
    private RatingService ratingService = new RatingServiceImpl();
    
    
    @GET
	public List<Rating> getRatings(@QueryParam("value") Integer value) {
    	List<Rating> ratingList = new ArrayList<Rating>();
    	try {
    		if(value != null) {
    			ratingList = ratingService.getRatingByValue(value);
    		}
    		else {
    			ratingList = ratingService.getAllRatings();
    		}
    	}
    	catch(Exception e){
    		log.debug("RatingService,getRatings,e: " + e);
    	}
    	
    	return ratingList;
    }
    
    
    @POST
	public void insertRating(Rating rating) {
    	try {
    		if(rating != null) {
    			ratingService.insertRating(rating);
    		}
    	}
    	catch(Exception e){
    		log.debug("RatingService,insertRating,e: " + e);
    	}
    }
	

    @PUT
   	@Path("{id}")
   	public void updateRating(@PathParam("id") Integer id, Rating rating) {
       	try {
       		if(rating != null) {
       			rating.setId(id);
       			ratingService.updateRating(rating);
       		}
       	}
       	catch(Exception e){
       		log.debug("RatingService,updateRating,e: " + e);
       	}
   	}
       
       
    @DELETE
   	@Path("{id}")
   	public void deleteRating(@PathParam("id") Integer id) {
       	try {
       		ratingService.deleteRating(id);
       	}
       	catch(Exception e){
       		log.debug("RatingService,deleteRating,e: " + e);
       	}
   	}
       
       
    @GET
   	@Path("{id}")
    public Rating getRatingById(@PathParam("id") Integer id) {
		Rating rating = new Rating();
	   	try {
	   		rating = ratingService.getRatingById(id);
	   	}
	   	catch(Exception e){
	   		log.debug("RatingService,getRatingById,e: " + e);
	   	}
	   	
		return rating;
    }
}
