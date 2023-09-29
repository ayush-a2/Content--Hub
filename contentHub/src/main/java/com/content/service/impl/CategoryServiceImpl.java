package com.content.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.content.exception.ResourceNotFoundException;
import com.content.model.Category;
import com.content.model.User;
import com.content.payloads.CategoryDto;
import com.content.repostories.CategoryRepo;
import com.content.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
	Category  cat=	modelMapper.map(categoryDto, Category.class);
	Category saveCat=this.categoryRepo.save(cat);
	
		return modelMapper.map(saveCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Category cat=categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category","Id",categoryId));
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
	cat.setCategorytitle(categoryDto.getCategorytitle());
		
		Category updatedCat=categoryRepo.save(cat);
		return modelMapper.map(updatedCat, CategoryDto.class); 
	}

	@Override
	public void deleteCategory(Integer categoryId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Category cat=categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category","Id",categoryId));
categoryRepo.delete(cat)
;	
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Category cat=categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category","Id",categoryId));
		return modelMapper.map(cat,CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		// TODO Auto-generated method stub
		List<Category> cat=categoryRepo.findAll();
		return cat.stream().map(cats ->modelMapper.map(cats,CategoryDto.class)).collect(Collectors.toList());
	}

}
