package com.exerciseBCI.controller;

import org.springframework.http.ResponseEntity;

import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.LoginResponseDTO;


public interface LoginController {

	ResponseEntity<LoginResponseDTO> login(LoginDTO body);
}
