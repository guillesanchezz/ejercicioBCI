package com.exerciseBCI.service.impl;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;


import com.exerciseBCI.dto.RegistroDTO;
import com.exerciseBCI.dto.UsuarioDTO;
import com.exerciseBCI.entity.UsuarioEntity;
import com.exerciseBCI.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceImplTest {

	@Mock
	private UsuarioRepository usuarioRepository;
		
	
	@InjectMocks
	private UsuarioServiceImpl usuarioServiceImpl;
	

}
