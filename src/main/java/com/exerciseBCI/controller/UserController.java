package com.exerciseBCI.controller;

import com.exerciseBCI.dto.RequestDTO;
import com.exerciseBCI.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserController {

    ResponseEntity<UserDTO> createUser(RequestDTO body);
}
