package com.content.exception;

public class ResourceNotFoundException extends Exception{
	String resourcename;
	 String fieldName;
	long fieldValue;
	
	
	   public ResourceNotFoundException(String resourcename,String fieldName,long fieldValue) {
	        super(String.format("%s not found with %s:%s", resourcename, fieldName, fieldValue));

	        this.resourcename=resourcename;
	        this.fieldName=fieldName;
	        this.fieldValue=fieldValue;
	    }
}
