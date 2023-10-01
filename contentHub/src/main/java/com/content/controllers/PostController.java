package com.content.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.content.exception.ResourceNotFoundException;
import com.content.model.Post;
import com.content.payloads.ApiResponse;
import com.content.payloads.PostDto;
import com.content.service.PostService;
import com.content.payloads.*;
@RestController
@RequestMapping("/api/posts")
public class PostController {
	@Autowired
	private PostService postService;
//create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable
			Integer userId,@PathVariable Integer categoryId ) throws ResourceNotFoundException{
		
	PostDto createPost=postService.createPost(postDto, userId, categoryId);
	
		
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	//getByUser
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>>  getPostsByUser(@PathVariable Integer userId) throws ResourceNotFoundException{
		List<PostDto>posts=this.postService.getPostsByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
		
	}
	//getPostsByCategory
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>>  getPostsByCategory(@PathVariable Integer categoryId) throws ResourceNotFoundException{
		List<PostDto>posts=this.postService.getPostsByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
		
	}
	//get all posts
	@GetMapping("/posts")
	public ResponseEntity<PostResponse>  getAllPosts( @RequestParam(value="pageNumber",
	defaultValue = "0",required = false) Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue = "2",required = false)
Integer pageSize){
		PostResponse postResponse =this.postService.getAllPost(pageNumber,pageSize);
		
		return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
	}
	// get single posts
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto>  getPostById(@PathVariable Integer postId) throws ResourceNotFoundException{
		PostDto posts=this.postService.getPostById( postId);
		
		return new ResponseEntity<PostDto>(posts,HttpStatus.OK);
	}
	//deletePost
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) throws ResourceNotFoundException{
		postService.deletePost(postId);
		return new ApiResponse("Post Deleted sucessFully", true);
	}
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId) throws ResourceNotFoundException{
	PostDto updatedPosts=this.postService.updatePost(postDto, postId);
		 
		return new ResponseEntity<PostDto>(updatedPosts,HttpStatus.OK);
		
	}
}
