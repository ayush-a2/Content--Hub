package com.content.service;
import com.content.exception.ResourceNotFoundException;
import com.content.payloads.*;
public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer postId) throws ResourceNotFoundException;

	void deleteComment(Integer commentId) throws ResourceNotFoundException;

}
