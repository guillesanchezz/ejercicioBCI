package com.exerciseBCI.controller.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.exerciseBCI.dto.PhoneDTO;
import com.exerciseBCI.dto.RegistroDTO;
import com.exerciseBCI.dto.UsuarioDTO;
import com.exerciseBCI.entity.TelefonoEntity;
import com.exerciseBCI.entity.UsuarioEntity;
import com.exerciseBCI.repository.UsuarioRepository;
import com.exerciseBCI.service.impl.UsuarioServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerImplTest {
	
	@Mock
	private UsuarioServiceImpl usuarioService;
		
	@InjectMocks
	private UsuarioControllerImpl usuarioControllerImpl;
	
	private Optional<UsuarioDTO> usuarioDTO;
	private PhoneDTO phoneDTO;
	private Optional<UsuarioEntity> usuarioEntity;
	private TelefonoEntity telefonoEntity;
	private Optional<RegistroDTO> registroDTO;
	
	@BeforeEach
	public void config() {
		phoneDTO = new PhoneDTO(1152293143,1,2);
		List<PhoneDTO> listPhoneDTO = new ArrayList<>();
		listPhoneDTO.add(phoneDTO);		
		usuarioDTO = Optional.ofNullable(new UsuarioDTO("Guillermo Sanchez","guille@dominio.cl","admin",listPhoneDTO,1,new Date(),new Date(),new Date(),"asd",true));
		
		usuarioEntity = Optional.ofNullable(new UsuarioEntity());
		telefonoEntity = new TelefonoEntity(1152293143,1,2,usuarioEntity.get());
		List<TelefonoEntity> listTelefonoEntity= new ArrayList<>();
		listTelefonoEntity.add(telefonoEntity);
		
		usuarioEntity.get().setName("Guillermo Sanchez");
		usuarioEntity.get().setEmail("guille@dominio.cl");
		usuarioEntity.get().setPassword("admin");
		usuarioEntity.get().setTelefonos(listTelefonoEntity);
		usuarioEntity.get().setId(1);
		usuarioEntity.get().setCreated(new Date());
		usuarioEntity.get().setModified(new Date());
		usuarioEntity.get().setLastLogin(new Date());
		usuarioEntity.get().setToken("asd");
		usuarioEntity.get().setIsActive(true);
		
		registroDTO = Optional.ofNullable(new RegistroDTO("Guillermo Sanchez","guille@dominio.cl","admin",listPhoneDTO));		
	}
	
	
	@Test
	void testGetUsuario() {
		when(this.usuarioService.getUsuario("1")).thenReturn(usuarioDTO);

		final ResponseEntity<UsuarioDTO> response = usuarioControllerImpl.getUsuario("1");

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(this.usuarioDTO.get(), response.getBody());
	}
	
	@Test
	void testCreateUsuario() {
		when(this.usuarioService.createUsuario(this.registroDTO.get())).thenReturn(this.usuarioDTO);
		final ResponseEntity<UsuarioDTO> response = usuarioControllerImpl.createUsuario(this.registroDTO.get());
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(this.usuarioDTO.get(), response.getBody());
	}
	
	@Test
	void testReplaceUsuario() {
		when(this.usuarioService.replaceUsuario("1", usuarioDTO.get())).thenReturn(this.usuarioDTO);
		final ResponseEntity<UsuarioDTO> response = usuarioControllerImpl.replaceUsuario("1", this.usuarioDTO.get());
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(this.usuarioDTO.get(), response.getBody());
	}
	
	
}
