package com.content.service;

import java.util.List;

import com.content.model.Post;
import com.content.payloads.PostDto;

public interface PostService {
Post createPost(PostDto postDto);

Post updatePost(PostDto postDto,Integer postId);

void deletePost(Integer postId);

List<Post>getAllPost();

Post getPostById(Integer postId);

List<Post>getPostsByCategory(Integer categoryId);

List<Post>getPostsByUser(Integer userId);

List<Post> searchPosts(String Keyword);

}
