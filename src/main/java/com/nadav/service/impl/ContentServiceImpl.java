package com.nadav.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.ContentDao;
import com.nadav.persistance.dao.impl.ContentDaoImpl;
import com.nadav.persistance.entities.Content;
import com.nadav.service.ContentService;

public class ContentServiceImpl implements ContentService{
	
	private final Logger log = Logger.getLogger(ContentServiceImpl.class);
	
	private ContentDao contentDao = new ContentDaoImpl();
	
	public ContentServiceImpl() {
		
	}

	@Override
	public void insertContent(Content content) {
		contentDao.insertContent(content);
		
	}

	@Override
	public void deleteContent(Integer contentId) {
		contentDao.deleteContent(contentId);
		
	}

	@Override
	public Content getContentById(Integer contentId) {
		Content content = contentDao.getContentById(contentId);
		return content;
	}

	@Override
	public List<Content> getContentByTitle(String title) {
		List<Content> contents = contentDao.getContentByTitle(title);
		return contents;
	}

	@Override
	public void updateContent(Content content) {
		contentDao.updateContent(content);
		
	}

	@Override
	public List<Content> getAllContents() {
		List<Content> contents = contentDao.getAllContents();
		return contents;
	}
	
	
}
