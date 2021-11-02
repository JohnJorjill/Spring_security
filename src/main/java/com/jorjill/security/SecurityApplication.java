package com.jorjill.security;

import com.jorjill.security.domain.Role;
import com.jorjill.security.domain.User;
import com.jorjill.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Jake Blake","jake","1234",new ArrayList<>()));
			userService.saveUser(new User(null, "Carrie Ann","ann","1234",new ArrayList<>()));
			userService.saveUser(new User(null, "Karl Johnson","kj","1234",new ArrayList<>()));
			userService.saveUser(new User(null, "Eric Peters","ep","1234",new ArrayList<>()));

			userService.addRoleToUser("jake","ROLE_USER");
			userService.addRoleToUser("ann","ROLE_MANAGER");
			userService.addRoleToUser("kj","ROLE_ADMIN");
			userService.addRoleToUser("ep","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("ep","ROLE_ADMIN");
			userService.addRoleToUser("ep","ROLE_USER");
		};
	}
}
