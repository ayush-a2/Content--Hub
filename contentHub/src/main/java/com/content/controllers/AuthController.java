package com.content.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.content.model.CurrentLoginUser;
import com.content.payloads.JwtAuthRequest;
import com.content.payloads.JwtAuthResponse;
import com.content.payloads.UserDto;
import com.content.repostories.CurrentUserRepo;
import com.content.security.CustomeUserDetailService;
import com.content.security.JwtTokenHelper;
import com.content.service.UserService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	@Autowired
	private CurrentUserRepo currentUserRepo; 
	
	@Autowired
	private  JwtTokenHelper jwtTokenHelper;
	@Autowired
	private CustomeUserDetailService userDetailsService;
	@Autowired
	private  AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;
	@PostMapping("/login")
public ResponseEntity<JwtAuthResponse>createToken(
@RequestBody JwtAuthRequest request

		) throws Exception{
	this.authenticate(request.getUsername(),request.getPasssword());
	
		currentUserRepo.deleteAll();
	
UserDetails userDetails=userDetailsService.loadUserByUsername(request.getUsername());


String token=jwtTokenHelper.generateToken(userDetails);
JwtAuthResponse response=new JwtAuthResponse();
response.setToken(token);
response.setId(userDetails.getUsername());
CurrentLoginUser currentLoginUser=new CurrentLoginUser();
currentLoginUser.setEmail((userDetails.getUsername()));
currentUserRepo.save(currentLoginUser);
return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);

}
	private void authenticate(String username, String passsword) throws Exception {
		// TODO Auto-generated method stub
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username, passsword);
		try {
			authenticationManager.authenticate(authenticationToken);

		}
		catch(BadCredentialsException e) {
			
			System.out.println("Invalid Details");
			throw new Exception("Invalid password And username Exception !!");
		}
		
	}
	//Register New User
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto){
	return new ResponseEntity<UserDto>(	this.userService.registerNewUser(userDto),HttpStatus.CREATED);
	}
}
