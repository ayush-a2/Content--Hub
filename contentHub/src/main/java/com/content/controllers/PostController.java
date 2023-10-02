package com.content.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.content.config.AppConstants;
import com.content.exception.ResourceNotFoundException;
import com.content.payloads.ApiResponse;
import com.content.payloads.PostDto;
import com.content.payloads.PostResponse;
import com.content.service.FileService;
import com.content.service.PostService;

import jakarta.servlet.http.HttpServletResponse;
@RestController
@RequestMapping("/api/posts")
public class PostController {
	@Autowired
	private PostService postService;
	@Autowired
	private FileService fileService;
	@Value("${project.image}")
	private String path;
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
	public ResponseEntity<PostResponse>  getAllPosts(
			@RequestParam(value="pageNumber",
	defaultValue = AppConstants.Page_Number,required = false) Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue = AppConstants.Page_Size,required = false)
Integer pageSize,
@RequestParam(value="sortBy",defaultValue = AppConstants.Sort_By,required=false) String sortBy,
@RequestParam(value="sortDir",defaultValue = AppConstants.Sort_Dir,required=false) String sortDir ){
		PostResponse postResponse =this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
		
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
	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(
		@PathVariable("keyword") String keyword){
		List<PostDto> posts=postService.searchPosts(keyword);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	//Post Image Upload
	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto>uploadPostImage(
			@RequestParam("image") MultipartFile image,
			@PathVariable Integer postId
			) throws IOException, ResourceNotFoundException{
		PostDto postDto=	postService.getPostById(postId);
	String fileName=	fileService.uploadImage(path, image);

	postDto.setImageName(fileName);
	PostDto updatePost=postService.updatePost(postDto, postId);
	return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
	}
    //method to serve files
    @GetMapping(value = "/post/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(
            @PathVariable("imageName") String imageName,
            HttpServletResponse response
    ) throws IOException {

        InputStream resource = this.fileService.getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream())   ;

    }
}
