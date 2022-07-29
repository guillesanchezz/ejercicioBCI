package com.exerciseBCI.service;

import java.util.List;
import java.util.Optional;

import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.RegistroDTO;
import com.exerciseBCI.dto.UsuarioDTO;

public interface UsuarioService {

    public Optional<UsuarioDTO> createUsuario(RegistroDTO usuario);

}
