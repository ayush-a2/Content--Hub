package com.content.repostories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.content.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
Optional<User>findByEmail(String email);
}
