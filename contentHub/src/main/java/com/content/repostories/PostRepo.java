package com.content.repostories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.content.model.*;
public interface PostRepo extends JpaRepository<Post,Integer> {
List<Post> findByUser(User user);
List<Category> findByCategory(Category category);
}
