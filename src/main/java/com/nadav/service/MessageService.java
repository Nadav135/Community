package com.nadav.service;

import java.util.List;

import com.nadav.persistance.entities.Message;

public interface MessageService {

	public void insertMessage(Message message);
	
	public void deleteMessage(Integer messageId);
	
	public Message getMessageById(Integer messageId);
	
	public List<Message> getMessageByText(String text);
		
	public void updateMessage(Message message);

	public List<Message> getAllMessages();
}
