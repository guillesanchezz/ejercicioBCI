package com.exerciseBCI.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.LoginResponseDTO;
import com.exerciseBCI.dto.UsuarioDTO;
import com.exerciseBCI.handler.PasswordIncorrectException;
import com.exerciseBCI.security.GeneratorJWT;
import com.exerciseBCI.service.LoginService;
import com.exerciseBCI.service.UsuarioService;

@Service
public class LoginServiceImpl implements LoginService{
	
	private UsuarioService usuarioService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public LoginServiceImpl(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}


	@Override
	public Optional<LoginResponseDTO> getToken(LoginDTO body) {
		Optional<UsuarioDTO> usuarioDTO = usuarioService.getUsuarioByEmail(body.getUser());
		if(!usuarioDTO.get().getPassword().equals(body.getPass())) {
			throw new PasswordIncorrectException();
		}
				
		final GeneratorJWT generatorJWT= new GeneratorJWT();
		String token = generatorJWT.generarToken(body.getUser(),body.getPass());
		
		usuarioService.updateToken(usuarioDTO.get().getId().toString(), token);
		
		LoginResponseDTO loginResonseDTO = new LoginResponseDTO("Bearer "+token);

		return Optional.ofNullable(loginResonseDTO);
	}

}
