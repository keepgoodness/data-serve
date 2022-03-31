package com.dataserve;

import com.dataserve.domain.Role;
import com.dataserve.domain.User;
import com.dataserve.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DataServeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataServeApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			//add roles
			Role role_user = userService.saveRole(new Role(null, "ROLE_USER"));
			Role role_manager = userService.saveRole(new Role(null, "ROLE_MANAGER"));
			Role role_admin = userService.saveRole(new Role(null, "ROLE_ADMIN"));
			Role role_super_admin = userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			//add users
			userService.saveUser(new User(null, "Yordan Lazarov", "ylazarov", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "Mihail Milanov", "mmilanov", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "George Georgiev", "ggeorgiev", "12345", new ArrayList<>()));
			userService.saveUser(new User(null, "Kalin Malinov", "djack", "123456", new ArrayList<>()));

			//ad role to user
			userService.addRoleToUser("ylazarov", role_user.getName());
			userService.addRoleToUser("ylazarov", role_admin.getName());
			userService.addRoleToUser("ylazarov", role_super_admin.getName());
			userService.addRoleToUser("djack", role_user.getName());
			userService.addRoleToUser("djack", role_manager.getName());
		};
	}

}
