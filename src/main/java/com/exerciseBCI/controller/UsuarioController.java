package com.exerciseBCI.controller;

import org.springframework.http.ResponseEntity;

import com.exerciseBCI.dto.RegistroDTO;
import com.exerciseBCI.dto.UsuarioDTO;

public interface UsuarioController {

	ResponseEntity<UsuarioDTO> crearUsuario(RegistroDTO body);
}
