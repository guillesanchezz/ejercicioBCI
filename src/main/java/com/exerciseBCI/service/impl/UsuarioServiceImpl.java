package com.exerciseBCI.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.exerciseBCI.dto.PhoneDTO;
import com.exerciseBCI.dto.RegistroDTO;
import com.exerciseBCI.dto.UsuarioDTO;
import com.exerciseBCI.entity.TelefonoEntity;
import com.exerciseBCI.entity.UsuarioEntity;
import com.exerciseBCI.handler.EmailValidationException;
import com.exerciseBCI.handler.EmailViolationException;
import com.exerciseBCI.handler.PasswordValidationException;
import com.exerciseBCI.handler.UsuarioNotFoundException;
import com.exerciseBCI.repository.TelefonoRepository;
import com.exerciseBCI.repository.UsuarioRepository;
import com.exerciseBCI.security.GeneratorJWT;
import com.exerciseBCI.service.UsuarioService;
import com.exerciseBCI.util.EmailValidator;
import com.exerciseBCI.util.PasswordValidator;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UsuarioRepository usuarioRepository;
		
	@Override
	public Optional<UsuarioDTO> createUsuario(RegistroDTO body) {
		logger.info("Se prentende crear un usuario");
		UsuarioEntity usuarioEntity = null;
		
		validate(body.getEmail(),body.getPassword());
			
		usuarioEntity = convertRegistroDTOToUsuarioEntity(body);
		UsuarioEntity usuarioEntity2 = null;
		
		
		try {
			usuarioEntity2 = usuarioRepository.save(usuarioEntity);
		}catch (DataIntegrityViolationException e) {
			throw new EmailViolationException();
		}
		catch (Exception e) {
		  throw e;
		}
		logger.info("Finaliza la creacion de usuario");		
		return Optional.ofNullable(convertUsuarioEntityToUsuarioDTO(usuarioEntity2));
		
	}


	private void validate(String email, String password) {
		final EmailValidator emailValidator = new EmailValidator();
		final PasswordValidator passwordValidator = new PasswordValidator();
				
		if(!emailValidator.validate(email)){
			throw new EmailValidationException();
		}
		
		if(!passwordValidator.validate(password)){
			throw new PasswordValidationException();
		}
	}
	
	private UsuarioEntity convertRegistroDTOToUsuarioEntity(RegistroDTO source) {
		
		final GeneratorJWT generatorJWT= new GeneratorJWT();
		String token = generatorJWT.generarToken(source.getEmail());
		
		UsuarioEntity usuarioEntity = new UsuarioEntity(source.getName(),
														source.getEmail(),
														source.getPassword(),
														new Date(),
														new Date(),
														new Date(),
														token,
														true);
			
		List<TelefonoEntity> listTelefono = convertPhoneDTOToTelefonoEntity(source.getPhones(), usuarioEntity);		
		usuarioEntity.setTelefonos(listTelefono);
		
		return usuarioEntity;
	
	}

	private List<TelefonoEntity> convertPhoneDTOToTelefonoEntity(List<PhoneDTO> phones, UsuarioEntity usuarioEntity) {
		List<TelefonoEntity> listTelefono = new ArrayList<>();				
		
		for (PhoneDTO phone : phones) {
			TelefonoEntity telefonoEntity = new TelefonoEntity();
			
			telefonoEntity.setNumber(phone.getNumber());
			telefonoEntity.setCityCode(phone.getCityCode());
			telefonoEntity.setCountryCode(phone.getCountryCode());
			telefonoEntity.setUsuario(usuarioEntity);
			
			listTelefono.add(telefonoEntity);
		}
		return listTelefono;
	}
	
	private UsuarioDTO convertUsuarioEntityToUsuarioDTO(UsuarioEntity source) {
		
		List<PhoneDTO> listPhone = convertTelefonoEntityToPhoneDTO(source);
				
		return new UsuarioDTO(source.getName(),
				source.getEmail(),
				source.getPassword(),
				listPhone, 
				source.getId(),
				source.getCreated(),
				source.getModified(),
				source.getLastLogin(),
				source.getToken(),
				source.getIsActive());
	}

	private List<PhoneDTO> convertTelefonoEntityToPhoneDTO(UsuarioEntity source) {
		List<PhoneDTO> listPhone = new ArrayList<>();
		
		for (TelefonoEntity telefono : source.getTelefonos()) {
			PhoneDTO phone = new PhoneDTO();
			
			phone.setNumber(telefono.getNumber());
			phone.setCityCode(telefono.getCityCode());
			phone.setCountryCode(telefono.getCountryCode());
			
			
			listPhone.add(phone);
		}
		return listPhone;
	}


	@Override
	public Optional<List<UsuarioDTO>> getUsuarios() {
		logger.info("Comienza la busqueda de usuarios");
		final List<UsuarioDTO> usuarios = usuarioRepository.findAll().stream()
				.map(usuario -> convertUsuarioEntityToUsuarioDTO(usuario)).collect(Collectors.toList());
		
		if (usuarios.size() == 0) {
			throw new UsuarioNotFoundException();
		}
		logger.info("Finaliza la busqueda de usuarios");
		return Optional.ofNullable(usuarios);
	}


	@Override
	public void deleteUsuario(String usuarioId) {
		logger.info("Se pretende eliminar usuario con ID : " + usuarioId);
		try {
			this.usuarioRepository.deleteById(Integer.valueOf(usuarioId));
			logger.info("Se eliminor usuario con ID : " + usuarioId);
		}catch (EmptyResultDataAccessException e) {
			throw new UsuarioNotFoundException();
		}catch (Exception e) {
			throw e;
		}
		
		
	}


	@Override
	public Optional<UsuarioDTO> getUsuario(String usuarioId) {
		
		logger.info("Comienza la busqueda de usuario con ID : " + usuarioId);
		Optional<UsuarioEntity> usuarioEntity = this.usuarioRepository.findById(Integer.valueOf(usuarioId));
			
		if (!usuarioEntity.isPresent()) {
			throw new UsuarioNotFoundException();
		}
		logger.info("Finaliza busqueda de usuario con ID: " + usuarioId);
		return Optional.ofNullable(convertUsuarioEntityToUsuarioDTO(usuarioEntity.get()));
	}


	@Override
	public Optional<UsuarioDTO> replaceUsuario(String usuarioId, UsuarioDTO body) {
		logger.info("Se pretende reemplazar usuario con ID: " + usuarioId);
		Optional<UsuarioEntity> usuarioEntity = this.usuarioRepository.findById(Integer.valueOf(usuarioId));
		
		if (!usuarioEntity.isPresent()) {
			throw new UsuarioNotFoundException();
		}
				
		validate(body.getEmail(),body.getPassword());

		UsuarioEntity usuarioNew = new UsuarioEntity();
		usuarioNew.setName(body.getName());
		usuarioNew.setEmail(body.getEmail());
		usuarioNew.setPassword(body.getPassword());
		usuarioNew.setTelefonos(convertPhoneDTOToTelefonoEntity(body.getPhones(), usuarioNew));
		usuarioNew.setLastLogin(body.getLastLogin());
		usuarioNew.setModified(body.getModified());
		usuarioNew.setCreated(body.getCreated());
		usuarioNew.setToken(body.getToken());
		usuarioNew.setIsActive(body.getIsActive());
		usuarioNew.setCreated(body.getCreated());		
		usuarioNew.setId(usuarioEntity.get().getId());
		
		UsuarioEntity usuarioEntitySave = null;
		try {
			usuarioEntitySave = usuarioRepository.save(usuarioNew);
			logger.info("Finalizo el reemplazo de usuario con ID: " + usuarioId);
		}catch (Exception e) {
			throw e;
		}
		
		
		return Optional.ofNullable(convertUsuarioEntityToUsuarioDTO(usuarioEntitySave));
		
	}
	
	@Override
	public Optional<UsuarioDTO> getUsuarioByEmail(String email) {
		logger.info("Comienza busqueda de usuario con email: " + email);
		Optional<UsuarioEntity> usuarioEntity = this.usuarioRepository.findByEmail(email);
			
		if (!usuarioEntity.isPresent()) {
			throw new UsuarioNotFoundException();
		}
		logger.info("Finaliza busqueda de usuario con email: " + email);
		return Optional.ofNullable(convertUsuarioEntityToUsuarioDTO(usuarioEntity.get()));
	}


	@Override
	public void updateToken(String usuarioId,String token) {
		
		logger.info("Comienza update de token de usuario con ID: " + usuarioId);
		Optional<UsuarioEntity> usuarioEntity = this.usuarioRepository.findById(Integer.valueOf(usuarioId));
		
		usuarioEntity.get().setLastLogin(new Date());
		usuarioEntity.get().setToken(token);
	
		try {
			usuarioRepository.save(usuarioEntity.get());
			logger.info("Finalizo update de token de usuario con ID: " + usuarioId);
		}catch (Exception e) {
			throw e;
		}
		
	}
	
	

}
