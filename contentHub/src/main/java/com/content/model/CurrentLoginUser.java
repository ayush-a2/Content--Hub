package com.content.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrentLoginUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
private String email;

	public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

	public CurrentLoginUser() {
	super();
}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
