package com.liferay.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.liferay.project.model.User;

public interface UserDAO extends JpaRepository<User, Long>{

	@Query
	public User findByUsernameAndPassword(String username, String password);
	
}