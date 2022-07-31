package com.exerciseBCI.service.impl;

import com.exerciseBCI.dto.RequestDTO;
import com.exerciseBCI.dto.UserDTO;
import com.exerciseBCI.entity.UserEntity;
import com.exerciseBCI.handler.EmailViolationException;
import com.exerciseBCI.repository.UserRepository;
import com.exerciseBCI.security.GeneratorJWT;
import com.exerciseBCI.service.UserService;
import com.exerciseBCI.util.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserRepository userRepository;
    private final Validator validator;
    private final GeneratorJWT generatorJWT;

    public UserServiceImpl(UserRepository userRepository, Validator validator, GeneratorJWT generatorJWT) {
        this.userRepository = userRepository;
        this.validator = validator;
        this.generatorJWT = generatorJWT;
    }

    @Override
    public Optional<UserDTO> createUser(RequestDTO requestDTO) {
        logger.info("Create user :" + requestDTO.toString());

        validator.validateUser(requestDTO);

        UserEntity userEntity = UserEntity.from(requestDTO);
        try {
            userRepository.save(userEntity);
        } catch (DataIntegrityViolationException e) {
            throw new EmailViolationException();
        }
        logger.info("Created user id:" + userEntity.getId());

        String token = generatorJWT.generateToken(userEntity.getEmail());
        return Optional.of(UserDTO.from(userEntity, token));
    }

}
