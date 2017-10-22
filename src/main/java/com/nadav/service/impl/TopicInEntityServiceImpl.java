package com.nadav.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.TopicInEntityDao;
import com.nadav.persistance.dao.impl.TopicInEntityDaoImpl;
import com.nadav.persistance.entities.TopicInEntity;
import com.nadav.service.TopicInEntityService;

public class TopicInEntityServiceImpl implements TopicInEntityService{
	
	private final Logger log = Logger.getLogger(TopicInEntityServiceImpl.class);
	
	private TopicInEntityDao topicInEntityDao = new TopicInEntityDaoImpl();
	
	public TopicInEntityServiceImpl() {
		
	}

	@Override
	public void insertTopicInEntity(TopicInEntity topicInEntity) {
		topicInEntityDao.insertTopicInEntity(topicInEntity);
		
	}

	@Override
	public void deleteTopicInEntity(Integer topicInEntityId) {
		topicInEntityDao.deleteTopicInEntity(topicInEntityId);
		
	}

	@Override
	public TopicInEntity getTopicInEntityById(Integer topicInEntityId) {
		TopicInEntity topicInEntity = topicInEntityDao.getTopicInEntityById(topicInEntityId);
		return topicInEntity;
	}

	@Override
	public void updateTopicInEntity(TopicInEntity topicInEntity) {
		topicInEntityDao.updateTopicInEntity(topicInEntity);
		
	}

	@Override
	public List<TopicInEntity> getAllTopicInEntities() {
		List<TopicInEntity> topicInEntities = topicInEntityDao.getAllTopicInEntities();
		return topicInEntities;
	}

}
