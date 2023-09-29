package com.content.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.content.payloads.CategoryDto;
import com.content.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@PostMapping("/")
public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
	CategoryDto categoryDto2=categoryService.createCategory(categoryDto);
	return new ResponseEntity<CategoryDto>(categoryDto2,HttpStatus.CREATED);
	
}
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer catId) throws ResourceNotFoundException{
		CategoryDto categoryDto2=categoryService.updateCategory(categoryDto,catId);
		return new ResponseEntity<CategoryDto>(categoryDto2,HttpStatus.OK);
		
	}
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId) throws ResourceNotFoundException{
categoryService.deleteCategory(catId);
		return new ResponseEntity<>(new ApiResponse("Category Deleted Sucessfully",true),HttpStatus.OK);	
	}
@GetMapping("/")
public ResponseEntity<List<CategoryDto>>getCategories(){
	List<CategoryDto> categories=categoryService.getCategories();
	return ResponseEntity.ok(categories);
	
}
@GetMapping("/{catId}")
public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId) throws ResourceNotFoundException{
	
	CategoryDto categoryDto=categoryService.getCategory(catId);
	return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
}
}
