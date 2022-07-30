package com.exerciseBCI.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @Type(type = "uuid-char")
    private UUID id = UUID.randomUUID();
    private String name;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PhoneEntity> telefonos = new ArrayList<>();
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private Boolean isActive;

    public UserEntity() {
        super();
    }

    public UserEntity(String name, String email, String password,
                      LocalDateTime created, LocalDateTime modified, LocalDateTime lastLogin, Boolean isActive) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
        this.isActive = isActive;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PhoneEntity> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<PhoneEntity> telefonos) {
        this.telefonos = telefonos;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public void updateLastLogin() {
        setLastLogin(LocalDateTime.now());
    }

}
