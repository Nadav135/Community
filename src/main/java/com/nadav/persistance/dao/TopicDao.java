package com.nadav.persistance.dao;

import java.util.List;

import com.nadav.persistance.entities.Topic;

public interface TopicDao {
	
	public void insertTopic(Topic topic);
	
	public void deleteTopic(Integer topicId);
	
	public Topic getTopicById(Integer topicId);
	
	public List<Topic> getTopicByName(String name);
		
	public void updateTopic(Topic topic);
	
	public List<Topic> getAllTopics();
}
