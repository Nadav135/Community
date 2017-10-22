package com.nadav.service;

import java.util.List;

import com.nadav.persistance.entities.Article;

public interface ArticleService {
	
	public void insertArticle(Article article);
	
	public void deleteArticle(Integer articleId);
	
	public Article getArticleById(Integer articleId);
	
	public List<Article> getArticleByTitle(String title);
		
	public void updateArticle(Article article);

	public List<Article> getAllArticles();
}
