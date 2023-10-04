package com.content.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.content.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
