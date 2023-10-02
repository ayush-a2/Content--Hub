package com.content.service;

import java.util.List;

import com.content.exception.ResourceNotFoundException;
import com.content.model.Post;
import com.content.payloads.PostDto;
import com.content.payloads.PostResponse;

public interface PostService {
PostDto createPost(PostDto postDto ,Integer userId,Integer categoryId)throws ResourceNotFoundException;

PostDto updatePost(PostDto postDto,Integer postId) throws ResourceNotFoundException;

void deletePost(Integer postId) throws ResourceNotFoundException;

PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);

PostDto getPostById(Integer postId)throws ResourceNotFoundException;

List<PostDto>getPostsByCategory(Integer categoryId) throws ResourceNotFoundException ;

List<PostDto>getPostsByUser(Integer userId) throws ResourceNotFoundException ;
//searchposts
List<PostDto> searchPosts(String Keyword);

}
