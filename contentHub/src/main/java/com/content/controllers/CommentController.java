package com.content.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.content.exception.ResourceNotFoundException;
import com.content.payloads.ApiResponse;
import com.content.payloads.CommentDto;
import com.content.service.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {
@Autowired
private	CommentService commentService;

@PostMapping("/post/{postId}/comments")
public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment,@PathVariable Integer postId) throws ResourceNotFoundException{
	CommentDto createComment=commentService.createComment(comment, postId);
	CommentDto commentDto=commentService.createComment(createComment, postId);
	return new ResponseEntity<CommentDto>(commentDto,HttpStatus.CREATED);
}
	@DeleteMapping("/comments/{commentID}")
	
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) throws ResourceNotFoundException{
		commentService.deleteComment( commentId);
		
		return new ResponseEntity<>(new ApiResponse("Comment deleted sucessfully", true),HttpStatus.CREATED);
	}
	

}