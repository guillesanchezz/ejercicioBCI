package com.exerciseBCI.service;

import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.UserDTO;

import java.util.Optional;

public interface LoginService {

    public Optional<UserDTO> login(LoginDTO body);
}
