package com.liferay.project.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Reference;

import com.liferay.project.dao.MessageDAO;
import com.liferay.project.model.Message;
import com.liferay.project.model.User;
import com.liferay.project.service.MessageService;
import com.liferay.project.service.UserService;

public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDAO messageDAO;
	
	@Reference
	private UserService userService;
	
	@Override
	public Message addMessage(long userId, String body) {
		User user = userService.fetchUser(userId);
		
		if (user != null) {
		Message message = new Message();
		message.setBody(body);
		message.setUser(user);
		message.setDate(new Date());
		
		return messageDAO.save(message);
		}
		
		return null;
	}

	@Override
	public void deleteMessage(long messageId) {
		messageDAO.deleteById(messageId);
	}

	@Override
	public List<Message> findAll() {
		return messageDAO.findAll();
	}

}
