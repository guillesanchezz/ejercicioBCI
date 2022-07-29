package com.exerciseBCI.convert;

import com.exerciseBCI.dto.PhoneDTO;
import com.exerciseBCI.entity.TelefonoEntity;
import com.exerciseBCI.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConvertTelefono {


    public List<PhoneDTO> convertTelefonoEntityToPhoneDTO(UsuarioEntity source) {
        return source.getTelefonos().stream()
                .map(telefonoEntity -> new PhoneDTO(telefonoEntity.getNumber(), telefonoEntity.getCityCode()
                        , telefonoEntity.getCountryCode()))
                .collect(Collectors.toList());
    }

    public List<TelefonoEntity> convertPhoneDTOToTelefonoEntity(List<PhoneDTO> phones, UsuarioEntity usuarioEntity) {
        return phones.stream().map(phoneDTO -> new TelefonoEntity(phoneDTO.getNumber(), phoneDTO.getCityCode(),
                phoneDTO.getCountryCode(), usuarioEntity)).collect(Collectors.toList());
    }
}
