package com.exerciseBCI.dto;

import com.exerciseBCI.entity.PhoneEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneDTO {
    private final Long number;
    private final Integer cityCode;
    private final String countryCode;

    public PhoneDTO(Long number, Integer cityCode, String countryCode) {
        super();
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
    }

    public static List<PhoneDTO> from(List<PhoneEntity> phonesEntity) {
        return phonesEntity.stream()
                .map(phone -> new PhoneDTO(phone.getNumber(), phone.getCityCode()
                        , phone.getCountryCode()))
                .collect(Collectors.toList());
    }

    public Long getNumber() {
        return number;
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

}
