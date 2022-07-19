package com.pmhung2.demojwt;

import com.pmhung2.demojwt.Service.UserService;
import com.pmhung2.demojwt.domain.Role;
import com.pmhung2.demojwt.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoJwtApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoJwtApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPERVISOR"));

            userService.saveUser(new User(null, "Johnathan", "John Wick", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Anderson", "Neo", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "Rambo", "John Rambo", "123456", new ArrayList<>()));
            userService.saveUser(new User(null, "Takezou", "Miyamoto Musashi", "1234567", new ArrayList<>()));

            userService.addRoleToUser("John Wick", "ROLE_USER");
            userService.addRoleToUser("Neo", "ROLE_MANAGER");
            userService.addRoleToUser("John Rambo", "ROLE_ADMIN");
            userService.addRoleToUser("Miyamoto Musashi", "ROLE_SUPERVISOR");
            userService.addRoleToUser("Miyamoto Musashi", "ROLE_ADMIN");
        };
    }
}
