package com.exerciseBCI.controller.impl;

import com.exerciseBCI.controller.UserController;
import com.exerciseBCI.dto.RequestDTO;
import com.exerciseBCI.dto.UserDTO;
import com.exerciseBCI.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody RequestDTO body) {
        logger.info("Init Create User for: " + body.toString());
        final Optional<UserDTO> result = userService.createUser(body);
        logger.info("End Create User");
        return new ResponseEntity<>(result.get(), HttpStatus.CREATED);
    }

}
