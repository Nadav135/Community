package com.nadav.persistance.dao;

import java.util.List;

import com.nadav.persistance.entities.Article;

public interface ArticleDao {
	
	public void insertArticle(Article article);
	
	public void deleteArticle(Integer articleId);
	
	public Article getArticleById(Integer articleId);
	
	public List<Article> getArticleByTitle(String title);
		
	public void updateArticle(Article article);

	public List<Article> getAllArticles();
}
