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

import com.nadav.persistance.entities.Content;
import com.nadav.service.ContentService;
import com.nadav.service.impl.ContentServiceImpl;

@Path("contents")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)	
public class ContentController {
	
	private final Logger log = Logger.getLogger(ContentController.class);
	
    private ContentService contentService = new ContentServiceImpl();
    
    
    @GET
	public List<Content> getContents(@QueryParam("title") String title) {
    	List<Content> contentList = new ArrayList<Content>();
    	try {
    		if(title != null) {
    			contentList = contentService.getContentByTitle(title);
    		}
    		else {
    			contentList = contentService.getAllContents();
    		}
    	}
    	catch(Exception e){
    		log.debug("ContentService,getContents,e: " + e);
    	}
    	
    	return contentList;
    }
    
    
    @POST
	public void insertContent(Content content) {
    	try {
    		if(content != null) {
    			contentService.insertContent(content);
    		}
    	}
    	catch(Exception e){
    		log.debug("ContentService,insertContent,e: " + e);
    	}
    }
	

    @PUT
   	@Path("{id}")
   	public void updateContent(@PathParam("id") Integer id, Content content) {
       	try {
       		if(content != null) {
       			content.setId(id);
       			contentService.updateContent(content);
       		}
       	}
       	catch(Exception e){
       		log.debug("ContentService,updateContent,e: " + e);
       	}
   	}
       
       
    @DELETE
   	@Path("{id}")
   	public void deleteContent(@PathParam("id") Integer id) {
       	try {
       		contentService.deleteContent(id);
       	}
       	catch(Exception e){
       		log.debug("ContentService,deleteContent,e: " + e);
       	}
   	}
       
       
    @GET
   	@Path("{id}")
    public Content getContentById(@PathParam("id") Integer id) {
		Content content = new Content();
	   	try {
	   		content = contentService.getContentById(id);
	   	}
	   	catch(Exception e){
	   		log.debug("ContentService,getContentById,e: " + e);
	   	}
	   	
		return content;
    }
	

}
