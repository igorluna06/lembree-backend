package com.lembree.backend.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "hash_password")
    private String hashPassword;

    @Column(name = "standard_deadline_hours")
    private int standardDeadlineHours;

    @Column(name = "active_persistent_notification")
    private boolean activePersistentNotification;

    @Column(name = "created_on")
    private Instant createdOn;

    protected UserEntity() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public int getStandardDeadlineHours() {
        return standardDeadlineHours;
    }

    public void setStandardDeadlineHours(int standardDeadlineHours) {
        this.standardDeadlineHours = standardDeadlineHours;
    }

    public boolean isActivePersistentNotification() {
        return activePersistentNotification;
    }

    public void setActivePersistentNotification(boolean activePersistentNotification) {
        this.activePersistentNotification = activePersistentNotification;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }
}
