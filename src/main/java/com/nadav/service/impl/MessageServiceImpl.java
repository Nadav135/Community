package com.nadav.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.MessageDao;
import com.nadav.persistance.dao.impl.MessageDaoImpl;
import com.nadav.persistance.entities.Message;
import com.nadav.service.MessageService;

public class MessageServiceImpl implements MessageService{

	private final Logger log = Logger.getLogger(MessageServiceImpl.class);
	
	private MessageDao messageDao = new MessageDaoImpl();
	
	public MessageServiceImpl() {
		
	}

	@Override
	public void insertMessage(Message message) {
		messageDao.insertMessage(message);
		
	}

	@Override
	public void deleteMessage(Integer messageId) {
		messageDao.deleteMessage(messageId);
		
	}

	@Override
	public Message getMessageById(Integer messageId) {
		Message message = messageDao.getMessageById(messageId);
		return message;
	}

	@Override
	public List<Message> getMessageByText(String text) {
		List<Message> messages = messageDao.getMessageByText(text);
		return messages;
	}

	@Override
	public void updateMessage(Message message) {
		messageDao.updateMessage(message);
		
	}

	@Override
	public List<Message> getAllMessages() {
		List<Message> messages = messageDao.getAllMessages();
		return messages;
	}
	
	
}
