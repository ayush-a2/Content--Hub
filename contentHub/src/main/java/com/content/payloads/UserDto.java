package com.content.payloads;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.content.model.Role;
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

private Set<RoleDto> roles = new HashSet<>();

public UserDto() {
	super();
}


public Set<RoleDto> getRoles() {
	return roles;
}


public void setRoles(Set<RoleDto> roles) {
	this.roles = roles;
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
