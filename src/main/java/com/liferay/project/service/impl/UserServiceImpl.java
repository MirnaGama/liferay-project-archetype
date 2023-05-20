package com.liferay.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liferay.project.dao.UserDAO;
import com.liferay.project.model.User;
import com.liferay.project.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User fetchUser(long userId) {
		User user = userDAO.getOne(userId);
		
		return user;
	}

	@Override
	public User addUser(User user) {
	
		return userDAO.save(user);
	}

	@Override
	public User updateUser(Long id, User user) {
		if (user.getId() != id) {
			return null;
		}
		
		Optional<User> oldUser = userDAO.findById(id);
		
		if (oldUser.isPresent()) {
			return userDAO.save(user);
		}
		
		return null;
	}

	@Override
	public void deleteUser(User user) {
		userDAO.delete(user);
	}

	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return userDAO.findByUsernameAndPassword(username, password);
	}

}
