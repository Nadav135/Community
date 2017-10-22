package com.nadav.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.ArticleDao;
import com.nadav.persistance.dao.impl.ArticleDaoImpl;
import com.nadav.persistance.entities.Article;
import com.nadav.service.ArticleService;

public class ArticleServiceImpl implements ArticleService{
	
	private final Logger log = Logger.getLogger(ArticleServiceImpl.class);
	
	private ArticleDao articleDao = new ArticleDaoImpl();

	public ArticleServiceImpl() {
		
	}

	@Override
	public void insertArticle(Article article) {
		articleDao.insertArticle(article);
		
	}

	@Override
	public void deleteArticle(Integer articleId) {
		articleDao.deleteArticle(articleId);
		
	}

	@Override
	public Article getArticleById(Integer articleId) {
		Article article = articleDao.getArticleById(articleId);
		return article;
	}

	@Override
	public List<Article> getArticleByTitle(String title) {
		List<Article> articles = articleDao.getArticleByTitle(title);
		return articles;
	}

	@Override
	public void updateArticle(Article article) {
		articleDao.updateArticle(article);
		
	}

	@Override
	public List<Article> getAllArticles() {
		List<Article> articles = articleDao.getAllArticles();
		return articles;
	}
	
	
}
