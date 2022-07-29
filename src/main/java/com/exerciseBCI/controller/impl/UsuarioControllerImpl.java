package com.exerciseBCI.controller.impl;

import com.exerciseBCI.controller.UsuarioController;
import com.exerciseBCI.dto.RegistroDTO;
import com.exerciseBCI.dto.UsuarioDTO;
import com.exerciseBCI.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UsuarioControllerImpl implements UsuarioController{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final UsuarioService usuarioService;
	
	public UsuarioControllerImpl(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@Override
	@PostMapping
	public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody RegistroDTO body) {
		logger.info("Crear usuario");
		final Optional<UsuarioDTO> result = usuarioService.createUsuario(body);
		logger.info("Finaliza Crear usuario");
		return new ResponseEntity<>(result.get(), HttpStatus.CREATED);
	}

}
