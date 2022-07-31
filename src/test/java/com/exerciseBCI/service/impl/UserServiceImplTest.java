package com.exerciseBCI.service.impl;


import com.exerciseBCI.ExerciseBciApplication;
import com.exerciseBCI.dto.RequestDTO;
import com.exerciseBCI.dto.UserDTO;
import com.exerciseBCI.fixture.UserFixture;
import com.exerciseBCI.handler.EmailValidationException;
import com.exerciseBCI.handler.EmailViolationException;
import com.exerciseBCI.handler.PasswordValidationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest(classes = ExerciseBciApplication.class)
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void whenArrivedRequestWithCorrectData_ThenUserIsCreated() {
        RequestDTO requestDTO = UserFixture.createRequestValid();
        Optional<UserDTO> userDTO = userService.createUser(requestDTO);

        assertThat(userDTO.isPresent()).isTrue();
        assertThat(requestDTO.getEmail()).isEqualTo(userDTO.get().getEmail());
        assertThat(requestDTO.getPassword()).isEqualTo(userDTO.get().getPassword());
        assertThat(requestDTO.getName()).isEqualTo(userDTO.get().getName());
    }

    @Test
    void whenArrivedRequestWithEmailInvalid_ThenExceptionIsThrow() {
        assertThatThrownBy(() -> userService.createUser(UserFixture.createRequestWithEmailInvalid()))
                .isInstanceOf(EmailValidationException.class);
    }

    @Test
    void whenArrivedRequestWithPasswordInvalid_ThenExceptionIsThrow() {
        assertThatThrownBy(() -> userService.createUser(UserFixture.createRequestWithPasswordInvalid()))
                .isInstanceOf(PasswordValidationException.class);
    }

    @Test
    void whenArrivedRequestAndTheUserAlreadyExists_ThenExceptionIsThrow() {
        assertThatThrownBy(() -> userService.createUser(UserFixture.createRequestWithEmailRegistered()))
                .isInstanceOf(EmailViolationException.class);
    }
}
