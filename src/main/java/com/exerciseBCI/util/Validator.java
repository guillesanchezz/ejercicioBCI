package com.exerciseBCI.util;

import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.RequestDTO;
import com.exerciseBCI.entity.UserEntity;
import com.exerciseBCI.handler.EmailValidationException;
import com.exerciseBCI.handler.PasswordIncorrectException;
import com.exerciseBCI.handler.PasswordValidationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class Validator {

    public static void validateUser(RequestDTO requestDTO) {
        if (isNull(requestDTO.getEmail()) || !EmailValidator.validate(requestDTO.getEmail())) {
            throw new EmailValidationException();
        }

        if (isNull(requestDTO.getPassword()) || !PasswordValidator.validate(requestDTO.getPassword())) {
            throw new PasswordValidationException();
        }
    }

    public void validatePassword(LoginDTO login, UserEntity userEntity) {
        BCryptPasswordEncoder encoder = new EncoderCustom();
        if (!encoder.matches(login.getPassword(), userEntity.getPassword())) {
            throw new PasswordIncorrectException();
        }
    }
}
