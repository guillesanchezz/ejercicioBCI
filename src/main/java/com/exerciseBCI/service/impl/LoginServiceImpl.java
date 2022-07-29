package com.exerciseBCI.service.impl;

import com.exerciseBCI.convert.ConvertUsuario;
import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.UsuarioDTO;
import com.exerciseBCI.entity.UsuarioEntity;
import com.exerciseBCI.handler.UsuarioNotFoundException;
import com.exerciseBCI.repository.UsuarioRepository;
import com.exerciseBCI.service.LoginService;
import com.exerciseBCI.util.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UsuarioRepository usuarioRepository;
    private final Validator validator;
    private final ConvertUsuario convertUsuario;

    public LoginServiceImpl(UsuarioRepository usuarioRepository, Validator validator, ConvertUsuario convertUsuario) {
        this.usuarioRepository = usuarioRepository;
        this.validator = validator;
        this.convertUsuario = convertUsuario;
    }

    @Override
    public Optional<UsuarioDTO> login(LoginDTO body) {

        logger.info("Login del usuario : " + body.getUser());
        Optional<UsuarioEntity> usuarioEntity =
                Optional.of(this.usuarioRepository.findByEmail(body.getUser())
                        .orElseThrow(UsuarioNotFoundException::new));

        validator.validarPassword(body, usuarioEntity.get());

        logger.info("Update lastLogin");
        updateLastLogin(usuarioEntity.get());

        UsuarioDTO usuarioDTO = convertUsuario.convertUsuarioEntityToUsuarioDTO(usuarioEntity.get());

        logger.info("Fin de Login del Usuario : " + body.getUser());
        return Optional.of(usuarioDTO);
    }

    private void updateLastLogin(UsuarioEntity usuarioEntity) {
        usuarioEntity.updateLastLogin();
        try{
            usuarioRepository.save(usuarioEntity);
        } catch (Exception e) {
            throw e;
        }

    }
}
