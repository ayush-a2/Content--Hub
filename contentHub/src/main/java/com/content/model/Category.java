package com.content.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
@Override
public String toString() {
	return "Category [categoryId=" + categoryId + ", categorytitle=" + categorytitle + ", categoryDescription="
			+ categoryDescription + "]";
}

}
