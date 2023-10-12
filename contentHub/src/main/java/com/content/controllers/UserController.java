package com.content.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.content.exception.ResourceNotFoundException;
import com.content.payloads.ApiResponse;
import com.content.payloads.ResetPasswordDto;
import com.content.payloads.UserDto;
import com.content.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
@Autowired
	private UserService userService;
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
	UserDto createduserDto=	userService.createUser(userDto);
		return new ResponseEntity<>(createduserDto,HttpStatus.CREATED);
	}
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId") Integer uid) throws ResourceNotFoundException{
	UserDto updatedUser=	userService.updateUser(userDto, uid);
	return ResponseEntity.ok(updatedUser);
	}
	//Only For Admin
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId) throws ResourceNotFoundException{
		userService.deleteUser( userId);
	return new ResponseEntity<>(new ApiResponse("User Deleted Sucessfully",true),HttpStatus.OK);
	}
	@GetMapping("/")
public ResponseEntity<List<UserDto>> getAllUsers(){
	return ResponseEntity.ok(userService.getAllUsers());
}
	@GetMapping("/{userId}")
public ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer userId) throws ResourceNotFoundException{
	return ResponseEntity.ok(userService.getUserById(userId));
}
	@PutMapping("/{email}")
	public ResponseEntity<String> updatePassword(@PathVariable String email,@RequestBody ResetPasswordDto resetPasswordDto) throws Exception{
		String msg=userService.updatePassword(email, resetPasswordDto);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
}
