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

import com.nadav.persistance.entities.Message;
import com.nadav.service.MessageService;
import com.nadav.service.impl.MessageServiceImpl;

@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageController {

	private final Logger log = Logger.getLogger(MessageController.class);
	
    private MessageService messageService = new MessageServiceImpl();
    
    
    @GET
	public List<Message> getMessages(@QueryParam("text") String text) {
    	List<Message> messageList = new ArrayList<Message>();
    	try {
    		if(text != null) {
    			messageList = messageService.getMessageByText(text);
    		}
    		else {
    			messageList = messageService.getAllMessages();
    		}
    	}
    	catch(Exception e){
    		log.debug("MessageService,getMessages,e: " + e);
    	}
    	
    	return messageList;
    }
    
    
    @POST
	public void insertMessage(Message message) {
    	try {
    		if(message != null) {
    			messageService.insertMessage(message);
    		}
    	}
    	catch(Exception e){
    		log.debug("MessageService,insertMessage,e: " + e);
    	}
    }
	

    @PUT
   	@Path("{id}")
   	public void updateMessage(@PathParam("id") Integer id, Message message) {
       	try {
       		if(message != null) {
       			message.setId(id);
       			messageService.updateMessage(message);
       		}
       	}
       	catch(Exception e){
       		log.debug("MessageService,updateMessage,e: " + e);
       	}
   	}
       
       
    @DELETE
   	@Path("{id}")
   	public void deleteMessage(@PathParam("id") Integer id) {
       	try {
       		messageService.deleteMessage(id);
       	}
       	catch(Exception e){
       		log.debug("MessageService,deleteMessage,e: " + e);
       	}
   	}
       
       
    @GET
   	@Path("{id}")
    public Message getMessageById(@PathParam("id") Integer id) {
		Message message = new Message();
	   	try {
	   		message = messageService.getMessageById(id);
	   	}
	   	catch(Exception e){
	   		log.debug("MessageService,getMessageById,e: " + e);
	   	}
	   	
		return message;
    }

}
