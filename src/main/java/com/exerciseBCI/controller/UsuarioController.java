package com.exerciseBCI.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.exerciseBCI.dto.RegistroDTO;
import com.exerciseBCI.dto.UsuarioDTO;


public interface UsuarioController {

	ResponseEntity<List<UsuarioDTO>> getUsuarios();
	
	ResponseEntity<UsuarioDTO> createUsuario(RegistroDTO body);

	ResponseEntity<Void> deleteUsuario(String usuarioId);

	ResponseEntity<UsuarioDTO> getUsuario(String usuarioId);

	ResponseEntity<UsuarioDTO> replaceUsuario(String usuarioId, UsuarioDTO body);
	
}
