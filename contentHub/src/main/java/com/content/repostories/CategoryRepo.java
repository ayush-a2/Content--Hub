package com.content.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.content.model.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
