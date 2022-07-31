package com.exerciseBCI.fixture;

import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.PhoneDTO;
import com.exerciseBCI.dto.RequestDTO;

import java.util.ArrayList;
import java.util.List;

public class UserFixture {

    public static RequestDTO createRequestValid() {
        PhoneDTO phoneDTO = new PhoneDTO(12345678L, 1, "2");
        List<PhoneDTO> listPhoneDTO = new ArrayList<>();
        listPhoneDTO.add(phoneDTO);

        return new RequestDTO("Guillermo Sanchez", "guillermo.sanchez@globallogic.cl", "pass22M", listPhoneDTO);
    }

    public static RequestDTO createRequestWithEmailInvalid() {
        PhoneDTO phoneDTO = new PhoneDTO(12345678L, 1, "2");
        List<PhoneDTO> listPhoneDTO = new ArrayList<>();
        listPhoneDTO.add(phoneDTO);

        return new RequestDTO("Guillermo Sanchez", "guillermo.sanchezgloballogic.cl", "pass22M", listPhoneDTO);
    }

    public static RequestDTO createRequestWithPasswordInvalid() {
        PhoneDTO phoneDTO = new PhoneDTO(12345678L, 1, "2");
        List<PhoneDTO> listPhoneDTO = new ArrayList<>();
        listPhoneDTO.add(phoneDTO);

        return new RequestDTO("Guillermo Sanchez", "guillermo.sanchez@globallogic.cl", "pass2M", listPhoneDTO);
    }

    public static RequestDTO createRequestWithEmailRegistered() {
        PhoneDTO phoneDTO = new PhoneDTO(12345678L, 1, "2");
        List<PhoneDTO> listPhoneDTO = new ArrayList<>();
        listPhoneDTO.add(phoneDTO);

        return new RequestDTO("Guillermo Sanchez", "guillermo.sanchez@dominio.cl", "pass22M", listPhoneDTO);
    }

    public static LoginDTO createRequestValidToLogin() {
        return new LoginDTO("guillermo.sanchez@dominio.cl", "pass22M");
    }

}
