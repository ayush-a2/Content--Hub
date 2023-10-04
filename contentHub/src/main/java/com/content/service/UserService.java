package com.content.service;

import java.util.List;

import com.content.exception.ResourceNotFoundException;
import com.content.payloads.UserDto;

public interface UserService {

	
	UserDto registerNewUser(UserDto userDto);
	
 UserDto createUser(UserDto userDto);
 UserDto updateUser(UserDto userDto,Integer userId) throws ResourceNotFoundException;
 UserDto	getUserById(Integer userId) throws ResourceNotFoundException;
 List<UserDto> getAllUsers();
 void deleteUser(Integer userId) throws ResourceNotFoundException ;
}
