package com.exerciseBCI.service.impl;

import com.exerciseBCI.convert.ConvertUsuario;
import com.exerciseBCI.dto.*;
import com.exerciseBCI.entity.UsuarioEntity;
import com.exerciseBCI.handler.*;
import com.exerciseBCI.repository.UsuarioRepository;
import com.exerciseBCI.service.UsuarioService;
import com.exerciseBCI.util.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UsuarioRepository usuarioRepository;
    private final Validator validator;
    private final ConvertUsuario convertUsuario;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, Validator validator, ConvertUsuario convertUsuario) {
        this.usuarioRepository = usuarioRepository;
        this.validator = validator;
        this.convertUsuario = convertUsuario;
    }

    @Override
    public Optional<UsuarioDTO> createUsuario(RegistroDTO body) {
        logger.info("crear un usuario :" + body.toString());

        validator.validarRegistroUsuario(body);

        UsuarioEntity usuarioEntity = convertUsuario.convertRegistroDTOToUsuarioEntity(body);
        try {
            usuarioEntity = usuarioRepository.save(usuarioEntity);
        } catch (DataIntegrityViolationException e) {
            throw new EmailViolationException();
        }
        logger.info("Finaliza la creacion de usuario");
        return Optional.of(convertUsuario.convertUsuarioEntityToUsuarioDTO(usuarioEntity));

    }

}
