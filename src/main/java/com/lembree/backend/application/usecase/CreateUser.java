package com.lembree.backend.application.usecase;

import com.lembree.backend.application.port.UserRepository;
import com.lembree.backend.domain.exception.EmailAlreadyInUseException;
import com.lembree.backend.domain.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreateUser {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User execute(String name, String email, String password) {

        if(userRepository.existsByEmail(email)){
            throw new EmailAlreadyInUseException(email);
        }

        String hashedPassword = passwordEncoder.encode(password);

        User createUser = User.newUser(name, email, hashedPassword);

        return userRepository.save(createUser);
    }

}
