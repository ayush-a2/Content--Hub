package com.content.service.impl;


import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.content.exception.ResourceNotFoundException;
import com.content.model.Category;
import com.content.model.Post;
import com.content.model.User;
import com.content.payloads.PostDto;
import com.content.payloads.PostResponse;
import com.content.repostories.CategoryRepo;
import com.content.repostories.PostRepo;
import com.content.repostories.UserRepo;
import com.content.service.PostService;
@Service
public class PostServiceImpl implements PostService {
	
@Autowired
	private PostRepo postRepo;
@Autowired
private ModelMapper modelMapper;
@Autowired
private UserRepo userrepo;
@Autowired
private CategoryRepo categoryRepo;
	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		User user=userrepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
		Category cat=categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category","Id",categoryId));
		Post post=modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(cat);
		Post savepost=postRepo.save(post);
		return modelMapper.map(savepost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Post post=postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("User","Id",postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
	
		Post updatedPost=postRepo.save(post);
		return modelMapper.map(updatedPost, PostDto.class);
		
	}

	@Override
	public void deletePost(Integer postId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Post post=postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("User","Id",postId));
		postRepo.delete(post);
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber,Integer pageSize) {
		// TODO Auto-generated method stub
		
		Pageable p=PageRequest.of(pageNumber, pageSize);
		Page<Post> pagePost=postRepo.findAll(p);
		List<Post>allPosts=	pagePost.getContent();
		List<PostDto>postDtos=	allPosts.stream().map((post)->modelMapper.map(post, PostDto.class)).collect(
				Collectors.toList());
		
	PostResponse postResponse=new PostResponse();
	postResponse.setContent(postDtos);
	postResponse.setPageNumber(pagePost.getNumber());
	postResponse.setPageSize(pagePost.getSize());
	postResponse.setTotalPages(pagePost.getTotalPages());
	postResponse.setTotalElements(pagePost.getTotalElements());
	postResponse.setLastPage(pagePost.isLast());
			return postResponse;
	}

	@Override
	public PostDto getPostById(Integer postId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Post post=postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("User","Id",postId));
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Category cat=categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category","Id",categoryId));
		
		List<Post> posts=postRepo.findByCategory(cat);
	List<PostDto>postDtos=	posts.stream().map((post)->modelMapper.map(post, PostDto.class)).collect(
			Collectors.toList());
	
		
		return postDtos;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		User user=userrepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
		
		List<Post>posts=postRepo.findByUser(user);
		List<PostDto> postDtos=posts.stream().map((post)->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<Post> searchPosts(String Keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
