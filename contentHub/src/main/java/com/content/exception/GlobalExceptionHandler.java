package com.content.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.content.payloads.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse api=new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(api,HttpStatus.NOT_FOUND);
	}
	
}
