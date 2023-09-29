package com.content.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.content.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
