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

import com.nadav.persistance.entities.Friend;
import com.nadav.service.FriendService;
import com.nadav.service.impl.FriendServiceImpl;

@Path("friends")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)	
public class FriendController{

	private final Logger log = Logger.getLogger(FriendController.class);
	
    private FriendService friendService = new FriendServiceImpl();
    
   
    @GET
	public List<Friend> getFriends(@QueryParam("userId") Integer userId,
									  @QueryParam("friendId") Integer friendId) {
    	List<Friend> friendList = new ArrayList<Friend>();
    	try {
    		if(userId > 0 && friendId > 0) {
    			Friend friend = friendService.getFriendship(userId, friendId);
    			friendList.add(friend);
    		}
    		else if(userId > 0 && friendId <= 0) {
    			friendList = friendService.getAllRelatedFriends(userId);
    		}
    		else {
    			friendList = friendService.getAllFriends();
    		}
    	}
    	catch(Exception e){
    		log.debug("FriendController,getFriends,e: " + e);
    	}
    	
    	return friendList;
    }
        
    
    @POST
	public void insertFriend(Friend friend) {
    	try {
    		if(friend != null) {
    			friendService.insertFriend(friend);
    		}
    	}
    	catch(Exception e){
    		log.debug("FriendController,insertFriend,e: " + e);
    	}
    }
    
    
    @PUT
	@Path("{id}")
	public void updateFriend(@PathParam("id") Integer id, Friend friend) {
    	try {
    		if(friend != null) {
    			friend.setFriendId(id);
    			friendService.updateFriend(friend);
    		}
    	}
    	catch(Exception e){
    		log.debug("FriendController,updateFriend,e: " + e);
    	}
	}
    
    
    @DELETE
	@Path("{id}")
	public void deleteFriend(@PathParam("id") Integer id) {
    	try {
    		friendService.deleteFriend(id);
    	}
    	catch(Exception e){
    		log.debug("FriendController,deleteFriend,e: " + e);
    	}
	}
    
    
    @GET
	@Path("{id}")
    public Friend getFriendById(@PathParam("id") Integer id) {
    	Friend friend = new Friend();
    	try {
    		friend = friendService.getFriendById(id);
    	}
    	catch(Exception e){
    		log.debug("FriendController,getFriendById,e: " + e);
    	}
    	
		return friend;
    }
    

}