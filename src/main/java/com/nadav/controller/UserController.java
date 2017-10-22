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

import com.nadav.persistance.entities.User;
import com.nadav.service.UserService;
import com.nadav.service.impl.UserServiceImpl;

@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)	
public class UserController {

	private final Logger log = Logger.getLogger(UserController.class);
	
    private UserService userService = new UserServiceImpl();
    
   
    @GET
	public List<User> getUsers(@QueryParam("name") String name,
							   @QueryParam("username") String username,
							   @QueryParam("lusername") String lusername,
							   @QueryParam("firsname") String firsname,
							   @QueryParam("lastname") String lastname) {
    	List<User> UserList = new ArrayList<User>();
    	try {
    		if(username != null) {
    			User user = userService.getUserByUsername(username);
    			UserList.add(user);
    		}
    		else if(lusername != null) {
    			UserList = userService.getUserLikeUsername(lusername);
    		}
    		else if(name != null) {
    			UserList = userService.getUserByName(name);
    		}
    		else if(firsname != null && lastname != null) {
    			User user = userService.getUserByFullname(firsname,lastname);
    			UserList.add(user);
    		}
    		else {
    			UserList = userService.getAllUsers();
    		}
    	}
    	catch(Exception e){
    		log.debug("UserController,getUsers,e: " + e);
    	}
    	
    	return UserList;
    }
        
    
    @POST
	public void insertUser(User User) {
    	try {
    		if(User != null) {
    			userService.insertUser(User);
    		}
    	}
    	catch(Exception e){
    		log.debug("UserController,insertUser,e: " + e);
    	}
    }
    
    
    @PUT
	@Path("{id}")
	public void updateUser(@PathParam("id") Integer id, User User) {
    	try {
    		if(User != null) {
    			User.setId(id);
    			userService.updateUser(User);
    		}
    	}
    	catch(Exception e){
    		log.debug("UserController,updateUser,e: " + e);
    	}
	}
    
    
    @DELETE
	@Path("{id}")
	public void deleteUser(@PathParam("id") Integer id) {
    	try {
    		userService.deleteUser(id);
    	}
    	catch(Exception e){
    		log.debug("UserController,deleteUser,e: " + e);
    	}
	}
    
    
    @GET
	@Path("{id}")
    public User getUserById(@PathParam("id") Integer id) {
    	User User = new User();
    	try {
    		User = userService.getUserById(id);
    	}
    	catch(Exception e){
    		log.debug("UserController,getUserById,e: " + e);
    	}
    	
		return User;
    }
    
  

}
