package com.liferay.project.service;

import java.util.List;

import com.liferay.project.model.Message;

public interface MessageService {
	
	public Message addMessage(long userId, String body);
	
	public void deleteMessage(long messageId);
	
	public List<Message> findAll();
}
