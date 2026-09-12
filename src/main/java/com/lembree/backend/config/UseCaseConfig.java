package com.lembree.backend.config;

import com.lembree.backend.application.port.UserRepository;
import com.lembree.backend.application.usecase.CreateUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UseCaseConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CreateUser createUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return new CreateUser(userRepository, passwordEncoder);
    }
}