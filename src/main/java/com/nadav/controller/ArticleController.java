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

import com.nadav.persistance.entities.Article;
import com.nadav.service.impl.ArticleServiceImpl;
import com.nadav.service.ArticleService;


@Path("articles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)	
public class ArticleController {
	
	private final Logger log = Logger.getLogger(ArticleController.class);
	
    private ArticleService articleService = new ArticleServiceImpl();
    
    
    @GET
	public List<Article> getArticle(@QueryParam("title") String title) {
    	List<Article> ArticleList = new ArrayList<Article>();
    	try {
    		if(title != null) {
    			ArticleList = articleService.getArticleByTitle(title);
    		}
    		else {
    			ArticleList = articleService.getAllArticles();
    		}
    	}
    	catch(Exception e){
    		log.debug("ArticleService,getArticle,e: " + e);
    	}
    	
    	return ArticleList;
    }
    
    
    @POST
	public void insertArticle(Article article) {
    	try {
    		if(article != null) {
    			articleService.insertArticle(article);
    		}
    	}
    	catch(Exception e){
    		log.debug("ArticleService,insertArticle,e: " + e);
    	}
    }
	

    @PUT
   	@Path("{id}")
   	public void updateArticle(@PathParam("id") Integer id, Article Article) {
       	try {
       		if(Article != null) {
       			Article.setId(id);
       			articleService.updateArticle(Article);
       		}
       	}
       	catch(Exception e){
       		log.debug("ArticleService,updateArticle,e: " + e);
       	}
   	}
       
       
    @DELETE
   	@Path("{id}")
   	public void deleteArticle(@PathParam("id") Integer id) {
       	try {
       		articleService.deleteArticle(id);
       	}
       	catch(Exception e){
       		log.debug("ArticleService,deleteArticle,e: " + e);
       	}
   	}
       
       
    @GET
   	@Path("{id}")
    public Article getArticleById(@PathParam("id") Integer id) {
		Article Article = new Article();
	   	try {
	   		Article = articleService.getArticleById(id);
	   	}
	   	catch(Exception e){
	   		log.debug("ArticleService,getArticleById,e: " + e);
	   	}
	   	
		return Article;
    }
	


}
