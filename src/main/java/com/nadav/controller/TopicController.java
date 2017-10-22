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

import com.nadav.persistance.entities.Topic;
import com.nadav.service.TopicService;
import com.nadav.service.impl.TopicServiceImpl;

@Path("topics")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)	
public class TopicController {

	private final Logger log = Logger.getLogger(TopicController.class);
	
    private TopicService topicService = new TopicServiceImpl();
    
    
    @GET
	public List<Topic> getTopics(@QueryParam("name") String name) {
    	List<Topic> topicList = new ArrayList<Topic>();
    	try {
    		if(name != null) {
    			topicList = topicService.getTopicByName(name);
    		}
    		else {
    			topicList = topicService.getAllTopics();
    		}
    	}
    	catch(Exception e){
    		log.debug("TopicService,getActivities,e: " + e);
    	}
    	
    	return topicList;
    }
    
    
    @POST
	public void insertTopic(Topic topic) {
    	try {
    		if(topic != null) {
    			topicService.insertTopic(topic);
    		}
    	}
    	catch(Exception e){
    		log.debug("TopicService,insertTopic,e: " + e);
    	}
    }
	

    @PUT
   	@Path("{id}")
   	public void updateTopic(@PathParam("id") Integer id, Topic topic) {
       	try {
       		if(topic != null) {
       			topic.setId(id);
       			topicService.updateTopic(topic);
       		}
       	}
       	catch(Exception e){
       		log.debug("TopicService,updateTopic,e: " + e);
       	}
   	}
       
       
    @DELETE
   	@Path("{id}")
   	public void deleteTopic(@PathParam("id") Integer id) {
       	try {
       		topicService.deleteTopic(id);
       	}
       	catch(Exception e){
       		log.debug("TopicService,deleteTopic,e: " + e);
       	}
   	}
       
       
    @GET
   	@Path("{id}")
    public Topic getTopicById(@PathParam("id") Integer id) {
		Topic topic = new Topic();
	   	try {
	   		topic = topicService.getTopicById(id);
	   	}
	   	catch(Exception e){
	   		log.debug("TopicService,getTopicById,e: " + e);
	   	}
	   	
		return topic;
    }
}
