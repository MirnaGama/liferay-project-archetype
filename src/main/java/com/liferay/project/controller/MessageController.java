package com.liferay.project.controller;

import java.util.List;

import org.springframework.data.annotation.Reference;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liferay.project.model.Message;
import com.liferay.project.model.User;
import com.liferay.project.service.MessageService;
import com.liferay.project.service.UserService;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Reference
    private UserService _userService;
	
	@Reference
	private MessageService _messageService;

	@GetMapping()
    public List<Message> getMessages(@RequestBody String username, String password) {
		
		User user = login(username, password);
		
		if (user != null) {
			List<Message> response = _messageService.findAll();
        	return response;
		}
		
		return null;
    }
    
	@PostMapping()
    public Message addMessage(@RequestBody String username, String password, String body) {
       
		User user = login(username, password);
		
		if (user != null) {
			return _messageService.addMessage(user.getId(), body);
		}
		
		return null;
    }
	
	@DeleteMapping()
    public void deleteMessage(@RequestBody String username, String password, Long messageId) {
       
		User user = login(username, password);
		
		if (user != null) {
			_messageService.deleteMessage(messageId);
		}
		
    }
    
    private User login(String username, String password) {
    	User user = _userService.findByUsernameAndPassword(username, password);

    	return user;
    }
}
