package com.exerciseBCI.controller.impl;

import com.exerciseBCI.ExerciseBciApplication;
import com.exerciseBCI.controller.UserController;
import com.exerciseBCI.dto.RequestDTO;
import com.exerciseBCI.dto.UserDTO;
import com.exerciseBCI.fixture.UserFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ExerciseBciApplication.class)
class UserControllerImplTest {

    @Autowired
    UserController userController;

    @Test
    void whenArrivedRequestWithCorrectData_ThenUserIsCreated() {
        RequestDTO requestDTO = UserFixture.createRequestValid();
        requestDTO.setEmail("guille.sanch@globallogic.cl");
        ResponseEntity<UserDTO> userDTO = userController.createUser(requestDTO);

        assertThat(userDTO.getStatusCode()).isEqualByComparingTo(HttpStatus.CREATED);
    }
}