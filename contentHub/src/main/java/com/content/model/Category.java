package com.content.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer categoryId;
	@Column(name="title",length=5,nullable=false)
private String categorytitle;
@Column(name="description")
private String categoryDescription;
@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
private List<Post> posts=new ArrayList<>();
public Category() {
	super();
}
public List<Post> getPosts() {
	return posts;
}
public void setPosts(List<Post> posts) {
	this.posts = posts;
}
public Integer getCategoryId() {
	return categoryId;
}
public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}
public String getCategorytitle() {
	return categorytitle;
}
public void setCategorytitle(String categorytitle) {
	this.categorytitle = categorytitle;
}
public String getCategoryDescription() {
	return categoryDescription;
}
public void setCategoryDescription(String categoryDescription) {
	this.categoryDescription = categoryDescription;
}


}
