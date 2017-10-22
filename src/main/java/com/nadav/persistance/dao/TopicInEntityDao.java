package com.nadav.persistance.dao;

import java.util.List;

import com.nadav.persistance.entities.TopicInEntity;

public interface TopicInEntityDao {
	
	public void insertTopicInEntity(TopicInEntity topicInEntity);
	
	public void deleteTopicInEntity(Integer topicInEntityId);
		
	public TopicInEntity getTopicInEntityById(Integer topicInEntityId);
		
	public void updateTopicInEntity(TopicInEntity topicInEntity);

	public List<TopicInEntity> getAllTopicInEntities();
}
