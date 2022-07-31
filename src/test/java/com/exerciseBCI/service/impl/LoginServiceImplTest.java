package com.exerciseBCI.service.impl;

import com.exerciseBCI.ExerciseBciApplication;
import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.UserDTO;
import com.exerciseBCI.fixture.UserFixture;
import com.exerciseBCI.handler.PasswordIncorrectException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest(classes = ExerciseBciApplication.class)
class LoginServiceImplTest {

    @Autowired
    private LoginServiceImpl loginService;


    @Test
    void whenArrivedRequestWithCorrectData_ThenUserLogin() {
        LoginDTO loginDTO = UserFixture.createRequestValidToLogin();
        Optional<UserDTO> userDTO = loginService.login(loginDTO);

        assertThat(userDTO.isPresent()).isTrue();
        assertThat(loginDTO.getEmail()).isEqualTo(userDTO.get().getEmail());
        assertThat(loginDTO.getPassword()).isEqualTo(userDTO.get().getPassword());
    }

    @Test
    void whenArrivedRequestWithIncorrectPassword_ThenExceptionThrow() {
        LoginDTO loginDTO = UserFixture.createRequestValidToLogin();
        loginDTO.setPassword("pas22M");

        assertThatThrownBy(() -> loginService.login(loginDTO))
                .isInstanceOf(PasswordIncorrectException.class);
    }

}