package com.liferay.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liferay.project.model.Message;

public interface MessageDAO extends JpaRepository<Message, Long>{

}
