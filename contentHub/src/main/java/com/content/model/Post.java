package com.content.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer postId;
	@Column(name="post_title",length=10,nullable=false)
private String title;
	@Column(length=100)
private String content;
	
private String imageName;
private Date addedDate;
@ManyToOne
@JoinColumn(name="category_id")
private Category category;
@ManyToOne
private User user;
@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
private Set<Comment>comments=new HashSet<>();
public Post() {
	super();
}
public Integer getPostId() {
	return postId;
}
public void setPostId(Integer postId) {
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
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

}
