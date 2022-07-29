package com.exerciseBCI.controller;

import com.exerciseBCI.dto.UsuarioDTO;
import org.springframework.http.ResponseEntity;

import com.exerciseBCI.dto.LoginDTO;


public interface LoginController {

	ResponseEntity<UsuarioDTO> login(LoginDTO body);
}
