package com.content.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.content.model.*;

import jakarta.persistence.Column;

public class PostDto {
	private int postId;
	private String title;
	
private String content;
	
private String imageName;
private Date addedDate;
private CategoryDto category;
private UserDto user;
private Set<Comment> comments=new HashSet<>();
public Set<Comment> getComments() {
	return comments;
}

public void setComments(Set<Comment> comments) {
	this.comments = comments;
}

public PostDto() {
	super();
}

public int getPostId() {
	return postId;
}

public void setPostId(int postId) {
	this.postId = postId;
}

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getImageName() {
	return imageName;
}
public void setImageName(String imageName) {
	this.imageName = imageName;
}
public Date getAddedDate() {
	return addedDate;
}
public void setAddedDate(Date addedDate) {
	this.addedDate = addedDate;
}
public CategoryDto getCategory() {
	return category;
}
public void setCategory(CategoryDto category) {
	this.category = category;
}
public UserDto getUser() {
	return user;
}
public void setUser(UserDto user) {
	this.user = user;
}



}
