package com.content.service;

import java.util.List;

import com.content.exception.ResourceNotFoundException;
import com.content.model.Post;
import com.content.payloads.PostDto;

public interface PostService {
PostDto createPost(PostDto postDto ,Integer userId,Integer categoryId)throws ResourceNotFoundException;

PostDto updatePost(PostDto postDto,Integer postId) throws ResourceNotFoundException;

void deletePost(Integer postId) throws ResourceNotFoundException;

List<PostDto>getAllPost();

PostDto getPostById(Integer postId)throws ResourceNotFoundException;

List<PostDto>getPostsByCategory(Integer categoryId) throws ResourceNotFoundException ;

List<PostDto>getPostsByUser(Integer userId) throws ResourceNotFoundException ;

List<Post> searchPosts(String Keyword);

}
