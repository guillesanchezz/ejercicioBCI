package com.exerciseBCI.convert;

import com.exerciseBCI.dto.PhoneDTO;
import com.exerciseBCI.entity.PhoneEntity;
import com.exerciseBCI.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConvertPhone {

    public List<PhoneDTO> convertPhoneEntityToPhoneDTO(UserEntity source) {
        return source.getPhones().stream()
                .map(phoneEntity -> new PhoneDTO(phoneEntity.getNumber(), phoneEntity.getCityCode()
                        , phoneEntity.getCountryCode()))
                .collect(Collectors.toList());
    }

    public List<PhoneEntity> convertPhoneDTOToPhoneEntity(List<PhoneDTO> phones, UserEntity userEntity) {
        return phones.stream().map(phoneDTO -> new PhoneEntity(phoneDTO.getNumber(), phoneDTO.getCityCode(),
                phoneDTO.getCountryCode(), userEntity)).collect(Collectors.toList());
    }
}
