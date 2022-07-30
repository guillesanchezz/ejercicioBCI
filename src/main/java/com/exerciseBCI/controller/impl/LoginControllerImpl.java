package com.exerciseBCI.controller.impl;

import com.exerciseBCI.controller.LoginController;
import com.exerciseBCI.dto.LoginDTO;
import com.exerciseBCI.dto.UserDTO;
import com.exerciseBCI.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class LoginControllerImpl implements LoginController {

    private final LoginService loginService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public LoginControllerImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    @PostMapping("login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginDTO body) {
        logger.info("Login de usuario");
        Optional<UserDTO> result = loginService.login(body);
        logger.info("Finaliza Login de usuario");
        return new ResponseEntity<>(result.get(), HttpStatus.OK);

    }


}
