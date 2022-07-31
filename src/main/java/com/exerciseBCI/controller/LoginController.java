package com.exerciseBCI.controller;

import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface LoginController {

    ResponseEntity<UserDTO> login(LoginDTO body);
}
