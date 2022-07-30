package com.exerciseBCI.service;

import java.util.Optional;

import com.exerciseBCI.dto.RequestDTO;
import com.exerciseBCI.dto.UserDTO;

public interface UserService {

    public Optional<UserDTO> createUser(RequestDTO requestDTO);

}
