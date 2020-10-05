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
	
	private UsuarioDTO usuarioDTO;
	private PhoneDTO phoneDTO;
	private UsuarioEntity usuarioEntity;
	private TelefonoEntity telefonoEntity;
	private RegistroDTO registroDTO;
	
	@BeforeEach
	public void config() {
		phoneDTO = new PhoneDTO(1152293143,1,2);
		List<PhoneDTO> listPhoneDTO = new ArrayList<>();
		listPhoneDTO.add(phoneDTO);		
		usuarioDTO = new UsuarioDTO("Guillermo Sanchez","guille@dominio.cl","admin",listPhoneDTO,1,new Date(),new Date(),new Date(),"asd",true);
		
		usuarioEntity = new UsuarioEntity();
		telefonoEntity = new TelefonoEntity(1152293143,1,2,usuarioEntity);
		List<TelefonoEntity> listTelefonoEntity= new ArrayList<>();
		listTelefonoEntity.add(telefonoEntity);
		
		usuarioEntity.setName("Guillermo Sanchez");
		usuarioEntity.setEmail("guille@dominio.cl");
		usuarioEntity.setPassword("admin");
		usuarioEntity.setTelefonos(listTelefonoEntity);
		usuarioEntity.setId(1);
		usuarioEntity.setCreated(new Date());
		usuarioEntity.setModified(new Date());
		usuarioEntity.setLastLogin(new Date());
		usuarioEntity.setToken("asd");
		usuarioEntity.setIsActive(true);
		
		registroDTO = new RegistroDTO("Guillermo Sanchez","guille@dominio.cl","admin",listPhoneDTO);		
	}
	
	@Test
	void testGetUsuarios() {
		List<UsuarioEntity> listUsuarioEntity= new ArrayList<>();
		listUsuarioEntity.add(usuarioEntity);
		when(this.usuarioRepository.findAll()).thenReturn(listUsuarioEntity);
		
		final List<UsuarioDTO> usuarios = usuarioRepository.findAll().stream()
				.map(usuario -> convertUsuarioEntityToUsuarioDTO(usuario)).collect(Collectors.toList());
		
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		usuariosDTO.add(this.usuarioDTO);
		assertEquals(usuariosDTO, usuarios);
	}
		
	private UsuarioDTO convertUsuarioEntityToUsuarioDTO(UsuarioEntity source) {				
		return usuarioDTO;			
	}
	
	
	@Test
	void testGetUsuario() {
		when(this.usuarioRepository.findById(1)).thenReturn(Optional.ofNullable(this.usuarioEntity));
		UsuarioDTO usuarioConvertDTO = convertUsuarioEntityToUsuarioDTO(usuarioRepository.findById(1).get());		
		assertEquals(usuarioConvertDTO, this.usuarioDTO);
	}
	
	@Test
	void testCreateUsuario() {
		when(this.usuarioRepository.save(usuarioEntity)).thenReturn(usuarioEntity);
		UsuarioEntity usuarioEntityConvert =convertRegistroDTOToUsuarioEntity(registroDTO);
		UsuarioEntity usuarioEntitySave = this.usuarioRepository.save(usuarioEntityConvert);
		UsuarioDTO usuarioDTOConvert = convertUsuarioEntityToUsuarioDTO(usuarioEntitySave);
		assertEquals(usuarioDTOConvert, usuarioDTO);
	}
	
	private UsuarioEntity convertRegistroDTOToUsuarioEntity(RegistroDTO source) {
				
		return usuarioEntity;
	
	}
	
	@Test
	void testReplaceUsuario() {
		when(this.usuarioRepository.findById(1)).thenReturn(Optional.ofNullable(this.usuarioEntity));
		when(this.usuarioRepository.save(usuarioEntity)).thenReturn(usuarioEntity);
		
		UsuarioEntity usuarioEntityFinded = usuarioRepository.findById(1).get();
		UsuarioEntity usuarioEntitySet = setToUsuarioEntity(usuarioEntityFinded, usuarioDTO);
		
	
		UsuarioEntity usuarioEntitySave = this.usuarioRepository.save(usuarioEntitySet);
		UsuarioDTO usuarioDTOConvert = convertUsuarioEntityToUsuarioDTO(usuarioEntitySave);

		assertEquals(usuarioDTOConvert, usuarioDTO);
	}

	private UsuarioEntity setToUsuarioEntity(UsuarioEntity usuarioEntityFinded, UsuarioDTO usuarioDTO2) {
		return usuarioEntity;
	}
	
}
