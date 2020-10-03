package com.exerciseBCI.controller.impl;

import java.util.List;
import java.util.Optional;

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
@RequestMapping("/api/v1")
public class UsuarioControllerImpl implements UsuarioController{
	
	private UsuarioService usuarioService;
	
	public UsuarioControllerImpl(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@Override
	@GetMapping(path="/usuarios/{usuarioId}")
	public ResponseEntity<UsuarioDTO> getUsuario(final @PathVariable("usuarioId") String usuarioId){
		
		final Optional<UsuarioDTO> result = usuarioService.getUsuario(usuarioId);

		return new ResponseEntity<>(result.get(), HttpStatus.OK);
	}
	
	
	@Override
	@GetMapping(path="/usuarios")
	public ResponseEntity<List<UsuarioDTO>> getUsuarios(){
		
		final Optional<List<UsuarioDTO>> result = usuarioService.getUsuarios();
		
		return new ResponseEntity<>(result.get(), HttpStatus.OK);
	}
	
	@Override
	@PostMapping(path="/usuarios")
	public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody RegistroDTO body) {
		
		final Optional<UsuarioDTO> result = usuarioService.createUsuario(body);
		
		return new ResponseEntity<>(result.get(), HttpStatus.CREATED);
	}
	
	@Override
	@DeleteMapping(path = "/usuarios/{usuarioId}")
	public ResponseEntity<Void> deleteUsuario(final @PathVariable("usuarioId") String usuarioId) {
		
		usuarioService.deleteUsuario(usuarioId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@Override
	@PutMapping(path = "/usuarios/{usuarioId}")
	public ResponseEntity<UsuarioDTO> replaceUsuario(final @PathVariable("usuarioId") String usuarioId,
			final @RequestBody UsuarioDTO usuarioResponseDTO) {

		final Optional<UsuarioDTO> result = usuarioService.replaceUsuario(usuarioId,usuarioResponseDTO);

		return new ResponseEntity<>(result.get(), HttpStatus.OK);
	}

}
