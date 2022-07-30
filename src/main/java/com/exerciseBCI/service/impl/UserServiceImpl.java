package com.exerciseBCI.service.impl;

import com.exerciseBCI.convert.ConvertUser;
import com.exerciseBCI.dto.*;
import com.exerciseBCI.entity.UserEntity;
import com.exerciseBCI.handler.*;
import com.exerciseBCI.repository.UserRepository;
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
    private final ConvertUser convertUser;

    public UserServiceImpl(UserRepository userRepository, Validator validator, ConvertUser convertUser) {
        this.userRepository = userRepository;
        this.validator = validator;
        this.convertUser = convertUser;
    }

    @Override
    public Optional<UserDTO> createUser(RequestDTO requestDTO) {
        logger.info("Create user :" + requestDTO.toString());

        validator.validarRegistroUsuario(requestDTO);

        UserEntity userEntity = convertUser.convertRequestDTOToUserEntity(requestDTO);
        try {
            userEntity = userRepository.save(userEntity);
        } catch (DataIntegrityViolationException e) {
            throw new EmailViolationException();
        }
        logger.info("Created user id:" + userEntity.getId() );
        return Optional.of(convertUser.convertUserEntityToUserDTO(userEntity));

    }

}
