package com.exerciseBCI.controller.impl;

import com.exerciseBCI.controller.LoginController;
import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.UserDTO;
import com.exerciseBCI.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class LoginControllerImpl implements LoginController {

    private final LoginService loginService;

    public LoginControllerImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    @PostMapping("login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginDTO body) {
        Optional<UserDTO> result = loginService.login(body);
        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }


}
