package com.content;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.content.config.AppConstants;
import com.content.model.Role;
import com.content.repostories.RoleRepo;

@SpringBootApplication
public class ContentHubApplication implements CommandLineRunner{
@Autowired
	private PasswordEncoder passwordEncoder;
@Autowired
private RoleRepo roleRepo;
	public static void main(String[] args) {
		SpringApplication.run(ContentHubApplication.class, args);
	}
@Bean
public ModelMapper modelMapper() {
	return new ModelMapper();
}
@Override
public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	System.out.println(passwordEncoder.encode("12345"));
try {
	Role role=new Role();
	role.setId(AppConstants.ADMIN_USER);
	role.setName("ROLE_ADMIN");
	
	Role role1=new Role();
	role1.setId(AppConstants.NORMAL_USER);
	role1.setName("ROLE_NORMAL");
	List<Role> roles=List.of(role,role1);
	List<Role> result=roleRepo.saveAll(roles);
	result.forEach(r->{
		System.out.println(r.getName());
	});
}catch(Exception e) {
	
}
}
}
