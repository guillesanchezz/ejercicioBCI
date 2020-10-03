package com.exerciseBCI.service;

import java.util.List;
import java.util.Optional;

import com.exerciseBCI.dto.RegistroDTO;
import com.exerciseBCI.dto.UsuarioDTO;

public interface UsuarioService {

	public Optional<UsuarioDTO> createUsuario(RegistroDTO usuario);

	public Optional<List<UsuarioDTO>> getUsuarios();
	
	public void deleteUsuario(String usuarioId);

	public Optional<UsuarioDTO> getUsuario(String usuarioId);

	public Optional<UsuarioDTO> replaceUsuario(String usuarioId, UsuarioDTO usuarioResponseDTO);
	
}
