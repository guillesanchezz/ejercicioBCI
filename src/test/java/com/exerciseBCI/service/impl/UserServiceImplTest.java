package com.exerciseBCI.service.impl;


import com.exerciseBCI.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;
		
	@InjectMocks
	private UserServiceImpl usuarioServiceImpl;

	@BeforeEach
	public void config() {

	}
	
	@Test
	void testCrearUsuario() {

	}
}
