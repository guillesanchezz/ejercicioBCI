package com.exerciseBCI.controller.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exerciseBCI.controller.UsuarioController;
import com.exerciseBCI.dto.RegistroDTO;
import com.exerciseBCI.dto.UsuarioDTO;
import com.exerciseBCI.handler.UsuarioNotFoundException;
import com.exerciseBCI.model.Usuario;
import com.exerciseBCI.service.UsuarioService;

@Controller
@RequestMapping("/users")
public class UsuarioControllerImpl implements UsuarioController{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private UsuarioService usuarioService;
	
	public UsuarioControllerImpl(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@Override
	@GetMapping(path="{userId}")
	public ResponseEntity<UsuarioDTO> getUsuario(final @PathVariable("userId") String usuarioId){
		logger.info("Obtener usuario con ID: " + usuarioId);
		final Optional<UsuarioDTO> result = usuarioService.getUsuario(usuarioId);
		logger.info("Finaliza Obtener usuario con ID: " + usuarioId);
		return new ResponseEntity<>(result.get(), HttpStatus.OK);
	}
	
	
	@Override
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> getUsuarios(){
		logger.info("Obtener usuarios");
		final Optional<List<UsuarioDTO>> result = usuarioService.getUsuarios();
		logger.info("Finaliza Obtener usuario");
		return new ResponseEntity<>(result.get(), HttpStatus.OK);
	}
	
	@Override
	@PostMapping
	public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody RegistroDTO body) {
		logger.info("Crear usuario");
		final Optional<UsuarioDTO> result = usuarioService.createUsuario(body);
		logger.info("Finaliza Crear usuario");
		return new ResponseEntity<>(result.get(), HttpStatus.CREATED);
	}
	
	@Override
	@DeleteMapping(path = "{userId}")
	public ResponseEntity<Void> deleteUsuario(final @PathVariable("userId") String usuarioId) {
		logger.info("Eliminar usuario con ID: " + usuarioId);
		usuarioService.deleteUsuario(usuarioId);
		logger.info("Finaliza eliminar usuario con ID: " + usuarioId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@Override
	@PutMapping(path = "{userId}")
	public ResponseEntity<UsuarioDTO> replaceUsuario(final @PathVariable("userId") String usuarioId,
			final @RequestBody UsuarioDTO usuarioResponseDTO) {
		logger.info("Reemplazar usuario con ID:" + usuarioId);
		final Optional<UsuarioDTO> result = usuarioService.replaceUsuario(usuarioId,usuarioResponseDTO);
		logger.info("Finaliza Reemplazar usuario con ID: "+ usuarioId);
		return new ResponseEntity<>(result.get(), HttpStatus.OK);
	}

}
