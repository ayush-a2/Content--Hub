package com.content.repostories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.content.model.Comment;
public interface CommentRepo  extends JpaRepository<Comment	, Integer> {

}