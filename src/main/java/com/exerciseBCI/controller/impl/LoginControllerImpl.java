package com.exerciseBCI.controller.impl;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exerciseBCI.controller.LoginController;
import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.LoginResponseDTO;
import com.exerciseBCI.service.LoginService;
import com.exerciseBCI.service.UsuarioService;

@Controller
@RequestMapping("/api/v1")
public class LoginControllerImpl implements LoginController {
	
	private LoginService loginService;
	
	public LoginControllerImpl(LoginService loginService) {
		this.loginService = loginService;
	}

	
	@Override
	@PostMapping(path="/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO body) {
		
		Optional<LoginResponseDTO> result = loginService.getToken(body); 
		return new ResponseEntity<>(result.get(), HttpStatus.OK);
	}
	
	
}
