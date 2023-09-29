package com.content.payloads;
import jakarta.validation.constraints.*;
public class UserDto {
	
private int id;
@NotNull
@Size(min=7,message=" Username must be min of 7 Character")
private String name;
@Email(message="This email is not valid")
private String email;
@NotNull
private String password;
@NotEmpty
private String about;
public UserDto() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAbout() {
	return about;
}
public void setAbout(String about) {
	this.about = about;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", about=" + about
			+ "]";
}



}
