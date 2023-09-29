package com.content.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.content.model.Post;
import com.content.payloads.PostDto;
import com.content.repostories.PostRepo;
import com.content.service.PostService;
@Service
public class PostServiceImpl implements PostService {
	
@Autowired
	private PostRepo postRepo;
@Autowired
private ModelMapper modelMapper;
	
	@Override
	public Post createPost(PostDto postDto) {
		// TODO Auto-generated method stub
		Post post=modelMapper.map(postDto, Post.class);
		Post savepost=postRepo.save(post);
		return savepostt;
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostsByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostsByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPosts(String Keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
