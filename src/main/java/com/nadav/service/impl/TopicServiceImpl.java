package com.nadav.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.TopicDao;
import com.nadav.persistance.dao.impl.TopicDaoImpl;
import com.nadav.persistance.entities.Topic;
import com.nadav.service.TopicService;

public class TopicServiceImpl implements TopicService{

	private final Logger log = Logger.getLogger(TopicServiceImpl.class);
	
	private TopicDao topicDao = new TopicDaoImpl();
	
	public TopicServiceImpl() {
		
	}

	@Override
	public void insertTopic(Topic topic) {
		topicDao.insertTopic(topic);
		
	}

	@Override
	public void deleteTopic(Integer topicId) {
		topicDao.deleteTopic(topicId);
		
	}

	@Override
	public Topic getTopicById(Integer topicId) {
		Topic topic = topicDao.getTopicById(topicId);
		return topic;
	}

	@Override
	public List<Topic> getTopicByName(String name) {
		List<Topic> topics = topicDao.getTopicByName(name);
		return topics;
	}

	@Override
	public void updateTopic(Topic topic) {
		topicDao.updateTopic(topic);
		
	}

	@Override
	public List<Topic> getAllTopics() {
		List<Topic> topics = topicDao.getAllTopics();
		return topics;
	}
}
