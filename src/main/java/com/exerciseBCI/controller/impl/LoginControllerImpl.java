package com.exerciseBCI.controller.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.exerciseBCI.controller.LoginController;
import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.LoginResponseDTO;
import com.exerciseBCI.service.LoginService;

@Controller
public class LoginControllerImpl implements LoginController {
	
	private LoginService loginService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public LoginControllerImpl(LoginService loginService) {
		this.loginService = loginService;
	}

	
	@Override
	@PostMapping("login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO body) {
		logger.info("Login de usuario");
		Optional<LoginResponseDTO> result = loginService.getToken(body); 
		logger.info("Finaliza Login de usuario");
		return new ResponseEntity<>(result.get(), HttpStatus.OK);
		
	}
	
	
}
