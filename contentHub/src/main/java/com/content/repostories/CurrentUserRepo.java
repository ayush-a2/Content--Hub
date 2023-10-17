package com.content.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.content.model.CurrentLoginUser;

public interface CurrentUserRepo extends JpaRepository<CurrentLoginUser, Integer>{
 public CurrentLoginUser findByEmail(String email);
}
