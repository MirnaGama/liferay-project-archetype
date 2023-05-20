package com.liferay.project.service;

import java.util.List;

import com.liferay.project.model.User;

public interface UserService {
	
	public User fetchUser(long userId);
	
	public User addUser(User user);
	
	public User updateUser(Long id, User user);
	
	public void deleteUser(User user);

	public List<User> findAll();
	
	public User findByUsernameAndPassword(String username, String password);
	
}
