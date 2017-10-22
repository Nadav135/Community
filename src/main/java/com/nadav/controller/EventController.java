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

import com.nadav.persistance.entities.Event;
import com.nadav.service.EventService;
import com.nadav.service.impl.EventServiceImpl;

@Path("events")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventController {
	
	private final Logger log = Logger.getLogger(EventController.class);
	
    private EventService eventService = new EventServiceImpl();
    
    
    @GET
	public List<Event> getEvents(@QueryParam("name") String name) {
    	List<Event> eventList = new ArrayList<Event>();
    	try {
    		if(name != null) {
    			eventList = eventService.getEventByName(name);
    		}
    		else {
    			eventList = eventService.getAllEvents();
    		}
    	}
    	catch(Exception e){
    		log.debug("EventService,getEvents,e: " + e);
    	}
    	
    	return eventList;
    }
    
    
    @POST
	public void insertEvent(Event event) {
    	try {
    		if(event != null) {
    			eventService.insertEvent(event);
    		}
    	}
    	catch(Exception e){
    		log.debug("EventService,insertEvent,e: " + e);
    	}
    }
	

    @PUT
   	@Path("{id}")
   	public void updateEvent(@PathParam("id") Integer id, Event event) {
       	try {
       		if(event != null) {
       			event.setId(id);
       			eventService.updateEvent(event);
       		}
       	}
       	catch(Exception e){
       		log.debug("EventService,updateEvent,e: " + e);
       	}
   	}
       
       
    @DELETE
   	@Path("{id}")
   	public void deleteEvent(@PathParam("id") Integer id) {
       	try {
       		eventService.deleteEvent(id);
       	}
       	catch(Exception e){
       		log.debug("EventService,deleteEvent,e: " + e);
       	}
   	}
       
       
    @GET
   	@Path("{id}")
    public Event getEventById(@PathParam("id") Integer id) {
		Event event = new Event();
	   	try {
	   		event = eventService.getEventById(id);
	   	}
	   	catch(Exception e){
	   		log.debug("EventService,getEventById,e: " + e);
	   	}
	   	
		return event;
    }
    


}
