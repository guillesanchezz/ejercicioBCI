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

    private final EmailValidator emailValidator;
    private final PasswordValidator passwordValidator;

    public Validator(EmailValidator emailValidator, PasswordValidator passwordValidator) {
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
    }

    public void validateUser(RequestDTO usuario) {
        if (isNull(usuario.getEmail()) || !emailValidator.validate(usuario.getEmail())) {
            throw new EmailValidationException();
        }

        if (isNull(usuario.getPassword()) || !passwordValidator.validate(usuario.getPassword())){
            throw new PasswordValidationException();
        }
    }

    public void validatePassword(LoginDTO login, UserEntity userEntity) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        if (!encoder.matches(login.getPassword(), userEntity.getPassword())){
            throw new PasswordIncorrectException();
        }
    }
}
