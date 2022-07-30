package com.exerciseBCI.convert;

import com.exerciseBCI.dto.RequestDTO;
import com.exerciseBCI.dto.UserDTO;
import com.exerciseBCI.entity.UserEntity;
import com.exerciseBCI.security.GeneratorJWT;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConvertUser {

    private final ConvertPhone convertPhone;
    private final GeneratorJWT generatorJWT;

    public ConvertUser(ConvertPhone convertPhone, GeneratorJWT generatorJWT) {
        this.convertPhone = convertPhone;
        this.generatorJWT = generatorJWT;
    }

    public UserEntity convertRequestDTOToUserEntity(RequestDTO source) {
        UserEntity userEntity = new UserEntity(source.getName(),
                source.getEmail(),
                source.getPassword(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                true);
        userEntity.setTelefonos(convertPhone.convertPhoneDTOToPhoneEntity(source.getPhones(), userEntity));

        return userEntity;

    }

    public UserDTO convertUserEntityToUserDTO(UserEntity source) {

        return new UserDTO(
                source.getName(),
                source.getEmail(),
                source.getPassword(),
                convertPhone.convertPhoneEntityToPhoneDTO(source),
                source.getId().toString(),
                source.getCreated(),
                source.getModified(),
                source.getLastLogin(),
                generatorJWT.generateToken(source.getEmail()),
                source.getIsActive());
    }
}
