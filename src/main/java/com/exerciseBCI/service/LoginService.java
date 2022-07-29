package com.exerciseBCI.service;

import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.RegistroDTO;
import com.exerciseBCI.dto.UsuarioDTO;

import java.util.Optional;

public interface LoginService {

    public Optional<UsuarioDTO> login(LoginDTO body);
}
