package com.exerciseBCI.service.impl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exerciseBCI.dto.PhoneDTO;
import com.exerciseBCI.dto.RegistroDTO;
import com.exerciseBCI.dto.UsuarioDTO;
import com.exerciseBCI.entity.TelefonoEntity;
import com.exerciseBCI.entity.UsuarioEntity;
import com.exerciseBCI.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceImplTest {

	@Mock
	private UsuarioRepository usuarioRepository;
		
	@InjectMocks
	private UsuarioServiceImpl usuarioServiceImpl;

	@BeforeEach
	public void config() {

	}
	
	@Test
	void testCrearUsuario() {

	}
}
