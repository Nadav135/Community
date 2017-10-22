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
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.nadav.persistance.entities.TopicInEntity;
import com.nadav.service.TopicInEntityService;
import com.nadav.service.impl.TopicInEntityServiceImpl;

@Path("topicInEntities")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TopicInEntityController {
	
private final Logger log = Logger.getLogger(TopicInEntityController.class);
	
    private TopicInEntityService topicInEntityService = new TopicInEntityServiceImpl();
    
    
    @GET
	public List<TopicInEntity> getTopicInEntities() {
    	List<TopicInEntity> topicInEntityList = new ArrayList<TopicInEntity>();
    	try {
    		topicInEntityList = topicInEntityService.getAllTopicInEntities();
    	}
    	catch(Exception e){
    		log.debug("TopicInEntityService,getTopicInEntities,e: " + e);
    	}
    	
    	return topicInEntityList;
    }
    
    
    @POST
	public void insertTopicInEntity(TopicInEntity topicInEntity) {
    	try {
    		if(topicInEntity != null) {
    			topicInEntityService.insertTopicInEntity(topicInEntity);
    		}
    	}
    	catch(Exception e){
    		log.debug("TopicInEntityService,insertTopicInEntity,e: " + e);
    	}
    }
	

    @PUT
   	@Path("{id}")
   	public void updateTopicInEntity(@PathParam("id") Integer id, TopicInEntity topicInEntity) {
       	try {
       		if(topicInEntity != null) {
       			topicInEntity.setId(id);
       			topicInEntityService.updateTopicInEntity(topicInEntity);
       		}
       	}
       	catch(Exception e){
       		log.debug("TopicInEntityService,updateTopicInEntity,e: " + e);
       	}
   	}
       
       
    @DELETE
   	@Path("{id}")
   	public void deleteTopicInEntity(@PathParam("id") Integer id) {
       	try {
       		topicInEntityService.deleteTopicInEntity(id);
       	}
       	catch(Exception e){
       		log.debug("TopicInEntityService,deleteTopicInEntity,e: " + e);
       	}
   	}
       
       
    @GET
   	@Path("{id}")
    public TopicInEntity getTopicInEntityById(@PathParam("id") Integer id) {
		TopicInEntity topicInEntity = new TopicInEntity();
	   	try {
	   		topicInEntity = topicInEntityService.getTopicInEntityById(id);
	   	}
	   	catch(Exception e){
	   		log.debug("TopicInEntityService,getTopicInEntityById,e: " + e);
	   	}
	   	
		return topicInEntity;
    }
	


}
