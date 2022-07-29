package com.exerciseBCI.convert;

import com.exerciseBCI.dto.RegistroDTO;
import com.exerciseBCI.dto.UsuarioDTO;
import com.exerciseBCI.entity.UsuarioEntity;
import com.exerciseBCI.security.GeneratorJWT;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConvertUsuario {

    private ConvertTelefono convertTelefono;
    private final GeneratorJWT generatorJWT;

    public ConvertUsuario(ConvertTelefono convertTelefono, GeneratorJWT generatorJWT) {
        this.convertTelefono = convertTelefono;
        this.generatorJWT = generatorJWT;
    }

    public UsuarioEntity convertRegistroDTOToUsuarioEntity(RegistroDTO source) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(source.getName(),
                source.getEmail(),
                source.getPassword(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                true);
        usuarioEntity.setTelefonos(convertTelefono.convertPhoneDTOToTelefonoEntity(source.getPhones(), usuarioEntity));

        return usuarioEntity;

    }

    public UsuarioDTO convertUsuarioEntityToUsuarioDTO(UsuarioEntity source) {

        return new UsuarioDTO(
                source.getName(),
                source.getEmail(),
                source.getPassword(),
                convertTelefono.convertTelefonoEntityToPhoneDTO(source),
                source.getId().toString(),
                source.getCreated(),
                source.getModified(),
                source.getLastLogin(),
                generatorJWT.generarToken(source.getEmail()),
                source.getIsActive());
    }
}
