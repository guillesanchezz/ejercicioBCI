package com.exerciseBCI.service;

import java.util.Optional;

import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.LoginResponseDTO;

public interface LoginService {
	
	public Optional<LoginResponseDTO> getToken(LoginDTO body);
}
