package com.exerciseBCI.dto;

import com.exerciseBCI.entity.PhoneEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PhoneDTO {
    private final Long number;
    private final Integer cityCode;
    private final String countryCode;

    public static List<PhoneDTO> from(List<PhoneEntity> phonesEntity) {
        return phonesEntity.stream()
                .map(phone -> new PhoneDTO(phone.getNumber(), phone.getCityCode()
                        , phone.getCountryCode()))
                .collect(Collectors.toList());
    }

}
