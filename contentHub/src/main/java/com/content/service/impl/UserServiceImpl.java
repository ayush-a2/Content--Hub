package com.content.service.impl;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.content.config.AppConstants;
import com.content.exception.ResourceNotFoundException;
import com.content.model.Role;
import com.content.model.User;
import com.content.payloads.UserDto;
import com.content.repostories.RoleRepo;
import com.content.repostories.UserRepo;
import com.content.service.UserService;
@Service
public class UserServiceImpl implements UserService {
@Autowired
	private UserRepo userrepo;
@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user=this.dtoToUser(userDto);
		User saveUser=	userrepo.save(user);
		return userToDto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto,Integer userId ) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		User user=userrepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
	
	user.setEmail(userDto.getEmail());
	user.setAbout(userDto.getAbout());
	user.setName(user.getName());
	user.setPassword(user.getPassword());
	User updateduser=userrepo.save(user);
	return userToDto(updateduser);
	}

	@Override
	public UserDto getUserById(Integer userId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
			User user=userrepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
			return userToDto(user);
			
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users=userrepo.findAll();
		return users.stream().map(user ->userToDto(user)).collect(Collectors.toList());
	}

	@Override
	public void deleteUser(Integer userId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		User user=userrepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
		userrepo.delete(user);

	}
	public User dtoToUser(UserDto userDto) {
		User user=modelMapper.map(userDto, User.class);
		
//		user.setId(userDto.getId());
//		user.setAbout(userDto.getAbout());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setName(userDto.getName());
		return user;
	}
public UserDto userToDto(User user) {
	UserDto userDto=modelMapper.map(user, UserDto.class);
//	userDto.setId(user.getId());
//	userDto.setName(user.getName());
//	userDto.setEmail(user.getEmail());
//	userDto.setPassword(user.getPassword());
//	userDto.setAbout(user.getAbout());
	return userDto;
	
}

@Override
public UserDto registerNewUser(UserDto userDto) {
	// TODO Auto-generated method stub
	User user= modelMapper.map(userDto, User.class);
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	//roles
	Role role=roleRepo.findById(AppConstants.NORMAL_USER).get();
	user.getRoles().add(role);
	User save=userrepo.save(user);
	return modelMapper.map(save, UserDto.class);
}
}
