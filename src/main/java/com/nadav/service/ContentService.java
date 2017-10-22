package com.nadav.service;

import java.util.List;

import com.nadav.persistance.entities.Content;

public interface ContentService {

	public void insertContent(Content content);
	
	public void deleteContent(Integer contentId);
	
	public Content getContentById(Integer contentId);
	
	public List<Content> getContentByTitle(String title);
		
	public void updateContent(Content content);

	public List<Content> getAllContents();
}
