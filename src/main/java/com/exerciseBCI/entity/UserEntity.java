package com.exerciseBCI.entity;

import com.exerciseBCI.dto.RequestDTO;
import com.exerciseBCI.util.EncoderCustom;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
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
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PhoneEntity> phones = new ArrayList<>();
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private Boolean isActive;


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

    public static UserEntity from(RequestDTO requestDTO){
        EncoderCustom encoderCustom = new EncoderCustom();
        String encodedPassword = encoderCustom.encode(requestDTO.getPassword());

        UserEntity userEntity = new UserEntity(requestDTO.getName(),
                requestDTO.getEmail(),
                encodedPassword,
                LocalDateTime.now(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                true);
        userEntity.setPhones(PhoneEntity.from(requestDTO.getPhones(), userEntity));

        return userEntity;
    }

    public void updateLastLogin() {
        setLastLogin(LocalDateTime.now());
    }

}
