package com.liferay.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="MESSAGE")
public class Message {

	@Id
	@Column(name="MESSAGE_ID")
	private Long id;
	
	@Column(name="MESSAGE_BODY")
	private String body;
	
	@OneToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@Column(name="MESSAGE_DATE")
	private Date date;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
