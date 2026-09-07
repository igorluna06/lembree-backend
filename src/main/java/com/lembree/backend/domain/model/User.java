package com.lembree.backend.domain.model;


import java.time.Instant;
import java.util.Objects;
import java.util.UUID;


public class User {

    private final UUID id;
    private String name;
    private String email;
    private String hashPassword;
    private int standardDeadlineHours;
    private boolean activePersistentNotification;
    private final Instant createdOn;

    public User(
            UUID id,
            String name,
            String email,
            String hashPassword,
            int standardDeadlineHours,
            boolean activePersistentNotification,
            Instant createdOn
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.hashPassword = Objects.requireNonNull(hashPassword, "hashPassword não pode ser nulo");
        this.standardDeadlineHours = validateStandardDeadlineHours(standardDeadlineHours);
        this.activePersistentNotification = activePersistentNotification;
        this.createdOn = Objects.requireNonNull(createdOn, "createdOn não pode ser nulo");
    }

    public static User newUser(String name, String email, String hashPassword){
        return new User(
                null,
                name,
                email,
                hashPassword,
                4,
                true,
                Instant.now()
        );
    }

    public void setStandardDeadlineHours(int standardDeadlineHours) {
        this.standardDeadlineHours = standardDeadlineHours;
    }

    public void activatePersistentNotification() {
        this.activePersistentNotification = true;
    }

    public void deactivatePersistentNotification() {
        this.activePersistentNotification = false;
    }

    private static String validateName(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        return name;
    }

    private static String validateEmail(String email){
        if(email == null || email.contains("@")){
            throw new IllegalArgumentException("Email inválido" + email);
        }
        return email;
    }

    private static int validateStandardDeadlineHours(int standardDeadlineHours){
        if(standardDeadlineHours <= 0){
            throw new IllegalArgumentException("Prazo padrão não pode ser zero ou negativo");
        }
        return standardDeadlineHours;
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

    public String getHashPassword() {
        return hashPassword;
    }

    public int getStandardDeadlineHours() {
        return standardDeadlineHours;
    }

    public boolean isActivePersistentNotification() {
        return activePersistentNotification;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(id);
    }

}
