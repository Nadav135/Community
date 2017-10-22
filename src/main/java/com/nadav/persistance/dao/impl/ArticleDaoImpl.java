package com.nadav.persistance.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nadav.persistance.dao.ArticleDao;
import com.nadav.persistance.entities.Article;

import javax.persistence.Query;

import org.apache.log4j.Logger;


public class ArticleDaoImpl implements ArticleDao{

	final static Logger logger = Logger.getLogger(ArticleDaoImpl.class);

	@Override
	public void insertArticle(Article article) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        	article.setCreatedAt(timestamp);
        	article.setUpdatedAt(timestamp);
        	session.saveOrUpdate(article);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ArticleDaoImpl,insertArticle,e: " + e);
        }
	}

	@Override
	public void deleteArticle(Integer articleId) {
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Article article = session.get(Article.class, articleId);
        	session.delete(article);
        	
        	trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ArticleDaoImpl,deleteArticle,e: " + e);
        }
	}

	@Override
	public Article getArticleById(Integer articleId) {
		Article result = new Article();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Article.GET_ARTICLE_BY_ID);
    		query.setParameter("id", articleId);
    		List<Article> articles = query.getResultList();
    		if(!articles.isEmpty()){
    			result = articles.get(0);
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ArticleDaoImpl,getArticleById,e: " + e);
        }
        return result;
	}

	@Override
	public List<Article> getArticleByTitle(String title) {
		List<Article> articleList = new ArrayList<Article>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    	    Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Article.GET_ALL_ARTICLES_BY_TITLE);
    		query.setParameter("title", "%" + title + "%");
    		List<Article> articles = query.getResultList();
    		if(!articles.isEmpty()){
    			for (Article art : articles) {
    				articleList.add(art);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ArticleDaoImpl,getArticleByTitle,e: " + e);
        }
        return articleList;
	}

	
	@Override
	public void updateArticle(Article article) {
		 try{
			SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
        	
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		article.setUpdatedAt(timestamp);
    		session.update(article);
        	
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ArticleDaoImpl,updateArticle,e: " + e);
        }
	}

	@Override
	public  List<Article> getAllArticles() {
		List<Article> articleList = new ArrayList<Article>();
        try{
        	SessionFactory sf;
    		sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		Query query = session.getNamedQuery(Article.GET_ALL_ARTICLES);
    		List<Article> articles = query.getResultList();
    		if(!articles.isEmpty()){
    			for (Article art : articles) {
    				articleList.add(art);
        		}
    		}
    		
    		trx.commit();
    		session.close();
    		sf.close();
        }
        catch(Exception e){
        	logger.debug("ArticleDaoImpl,getAllArticles,e: " + e);
        }
        return articleList;
	}
}
