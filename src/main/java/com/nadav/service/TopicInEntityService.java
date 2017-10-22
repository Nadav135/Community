package com.nadav.service;

import java.util.List;

import com.nadav.persistance.entities.TopicInEntity;

public interface TopicInEntityService {

	public void insertTopicInEntity(TopicInEntity topicInEntity);
	
	public void deleteTopicInEntity(Integer topicInEntityId);
		
	public TopicInEntity getTopicInEntityById(Integer topicInEntityId);
		
	public void updateTopicInEntity(TopicInEntity topicInEntity);

	public List<TopicInEntity> getAllTopicInEntities();
}
