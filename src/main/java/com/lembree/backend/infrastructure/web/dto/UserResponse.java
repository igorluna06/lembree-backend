package com.lembree.backend.infrastructure.web.dto;

import com.lembree.backend.domain.model.User;

import java.time.Instant;
import java.util.UUID;

public class UserResponse {

    private UUID id;
    private String name;
    private String email;
    private Instant createdOn;

    public UserResponse(UUID id, String name, String email, Instant createdOn) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdOn = createdOn;
    }

    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedOn()
        );
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }
}
