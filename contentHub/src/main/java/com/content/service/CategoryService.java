package com.content.service;

import java.util.List;

import com.content.exception.ResourceNotFoundException;
import com.content.payloads.CategoryDto;

public interface CategoryService {
public CategoryDto createCategory(CategoryDto categoryDto);
CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId)  throws ResourceNotFoundException;
void deleteCategory(Integer categoryId) throws ResourceNotFoundException;
CategoryDto  getCategory(Integer categoryId) throws ResourceNotFoundException;
List<CategoryDto> getCategories();
}
