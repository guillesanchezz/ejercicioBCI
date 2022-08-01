package com.exerciseBCI.service.impl;

import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.UserDTO;
import com.exerciseBCI.entity.UserEntity;
import com.exerciseBCI.handler.UserNotFoundException;
import com.exerciseBCI.repository.UserRepository;
import com.exerciseBCI.security.GeneratorJWT;
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
    private final GeneratorJWT generatorJWT;

    public LoginServiceImpl(UserRepository userRepository, Validator validator, GeneratorJWT generatorJWT) {
        this.userRepository = userRepository;
        this.validator = validator;
        this.generatorJWT = generatorJWT;
    }

    @Override
    public Optional<UserDTO> login(LoginDTO body) {
        logger.info("User Login: " + body.getEmail());
        Optional<UserEntity> userEntity =
                Optional.of(this.userRepository.findByEmail(body.getEmail())
                        .orElseThrow(UserNotFoundException::new));

        validator.validatePassword(body, userEntity.get());

        logger.info("Update lastLogin");
        updateLastLogin(userEntity.get());

        String token = generatorJWT.generateToken(userEntity.get().getEmail());
        UserDTO userDTO = UserDTO.from(userEntity.get(), token);
        userDTO.setPassword(body.getPassword());

        logger.info("User Login end: " + body.getEmail());
        return Optional.of(userDTO);
    }

    private void updateLastLogin(UserEntity userEntity) {
        userEntity.updateLastLogin();
        userRepository.save(userEntity);
    }
}
