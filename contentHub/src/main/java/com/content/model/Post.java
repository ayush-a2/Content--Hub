package com.content.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
}
