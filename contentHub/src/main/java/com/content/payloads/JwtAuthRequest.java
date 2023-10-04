package com.content.payloads;

public class JwtAuthRequest {
private String username;
private String passsword;


public JwtAuthRequest() {
	super();
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPasssword() {
	return passsword;
}
public void setPasssword(String passsword) {
	this.passsword = passsword;
}
	
}
