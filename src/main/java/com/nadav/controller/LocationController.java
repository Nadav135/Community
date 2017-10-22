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

import com.nadav.persistance.entities.Location;
import com.nadav.service.LocationService;
import com.nadav.service.impl.LocationServiceImpl;

@Path("locations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LocationController {
	
	private final Logger log = Logger.getLogger(LocationController.class);
	
    private LocationService locationService = new LocationServiceImpl();
    
    
    @GET
	public List<Location> getLocations(@QueryParam("name") String name) {
    	List<Location> locationList = new ArrayList<Location>();
    	try {
    		if(name != null) {
    			locationList = locationService.getLocationByName(name);
    		}
    		else {
    			locationList = locationService.getAllLocations();
    		}
    	}
    	catch(Exception e){
    		log.debug("LocationService,getLocations,e: " + e);
    	}
    	
    	return locationList;
    }
    
    
    @POST
	public void insertLocation(Location location) {
    	try {
    		if(location != null) {
    			locationService.insertLocation(location);
    		}
    	}
    	catch(Exception e){
    		log.debug("LocationService,insertLocation,e: " + e);
    	}
    }
	

    @PUT
   	@Path("{id}")
   	public void updateLocation(@PathParam("id") Integer id, Location location) {
       	try {
       		if(location != null) {
       			location.setId(id);
       			locationService.updateLocation(location);
       		}
       	}
       	catch(Exception e){
       		log.debug("LocationService,updateLocation,e: " + e);
       	}
   	}
       
       
    @DELETE
   	@Path("{id}")
   	public void deleteLocation(@PathParam("id") Integer id) {
       	try {
       		locationService.deleteLocation(id);
       	}
       	catch(Exception e){
       		log.debug("LocationService,deleteLocation,e: " + e);
       	}
   	}
       
       
    @GET
   	@Path("{id}")
    public Location getLocationById(@PathParam("id") Integer id) {
		Location location = new Location();
	   	try {
	   		location = locationService.getLocationById(id);
	   	}
	   	catch(Exception e){
	   		log.debug("LocationService,getLocationById,e: " + e);
	   	}
	   	
		return location;
    }

}
