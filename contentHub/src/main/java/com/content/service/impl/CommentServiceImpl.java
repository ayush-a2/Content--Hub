package com.content.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.content.exception.ResourceNotFoundException;
import com.content.model.Comment;
import com.content.model.Post;
import com.content.payloads.CommentDto;
import com.content.repostories.CommentRepo;
import com.content.repostories.PostRepo;
import com.content.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private ModelMapper modelMapper;
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Post post=postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("postId","Id",postId));
		Comment comment=modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment saveComment=commentRepo.save(comment);
		
		return modelMapper.map(saveComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Comment comment=commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("commentId","Id",commentId));
		commentRepo.delete(comment);	}

}
