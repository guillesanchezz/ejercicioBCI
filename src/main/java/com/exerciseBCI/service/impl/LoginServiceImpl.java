package com.exerciseBCI.service.impl;

import com.exerciseBCI.convert.ConvertUser;
import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.UserDTO;
import com.exerciseBCI.entity.UserEntity;
import com.exerciseBCI.handler.UserNotFoundException;
import com.exerciseBCI.repository.UserRepository;
import com.exerciseBCI.service.LoginService;
import com.exerciseBCI.util.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserRepository userRepository;
    private final Validator validator;
    private final ConvertUser convertUser;

    public LoginServiceImpl(UserRepository userRepository, Validator validator, ConvertUser convertUser) {
        this.userRepository = userRepository;
        this.validator = validator;
        this.convertUser = convertUser;
    }

    @Override
    public Optional<UserDTO> login(LoginDTO body) {

        logger.info("User Login: " + body.getEmail());
        Optional<UserEntity> usuarioEntity =
                Optional.of(this.userRepository.findByEmail(body.getEmail())
                        .orElseThrow(UserNotFoundException::new));

        validator.validarPassword(body, usuarioEntity.get());

        logger.info("Update lastLogin");
        updateLastLogin(usuarioEntity.get());

        UserDTO userDTO = convertUser.convertUserEntityToUserDTO(usuarioEntity.get());

        logger.info("User Login end: " + body.getEmail());
        return Optional.of(userDTO);
    }

    private void updateLastLogin(UserEntity userEntity) {
        userEntity.updateLastLogin();
        try {
            userRepository.save(userEntity);
        } catch (Exception e) {
            throw e;
        }

    }
}
