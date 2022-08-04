package com.exerciseBCI.fixture;

import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.PhoneDTO;
import com.exerciseBCI.dto.RequestDTO;

import java.util.ArrayList;
import java.util.List;

public class UserFixture {

    public static RequestDTO createRequestValid() {
        return RequestDTO.builder().name("Guillermo Sanchez")
                .email("guillermo.sanchez@globallogic.cl")
                .password("pass22M")
                .phones(getPhoneDTOS())
                .build();
    }

    public static RequestDTO createRequestWithEmailInvalid() {
        return RequestDTO.builder()
                .name("Guillermo Sanchez")
                .email("guillermo.sanchezgloballogic.cl")
                .password("pass22M")
                .phones(getPhoneDTOS())
                .build();
    }

    public static RequestDTO createRequestWithPasswordInvalid() {
        return RequestDTO.builder()
                .name("Guillermo Sanchez")
                .email("guillermo.sanchez@globallogic.cl")
                .password("pass2M")
                .phones(getPhoneDTOS())
                .build();
    }

    public static RequestDTO createRequestWithEmailRegistered() {
        return RequestDTO.builder()
                .name("Guillermo Sanchez")
                .email("guillermo.sanchez@dominio.cl")
                .password("pass22M")
                .phones(getPhoneDTOS())
                .build();
    }

    private static List<PhoneDTO> getPhoneDTOS() {
        PhoneDTO phoneDTO = PhoneDTO.builder().number(12345678L).cityCode(1).countryCode("2").build();
        List<PhoneDTO> listPhoneDTO = new ArrayList<>();
        listPhoneDTO.add(phoneDTO);
        return listPhoneDTO;
    }

    public static LoginDTO createRequestValidToLogin() {
        return LoginDTO.builder()
                .email("guillermo.sanchez@dominio.cl")
                .password("pass22M")
                .build();
    }

}
