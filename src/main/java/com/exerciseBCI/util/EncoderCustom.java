package com.exerciseBCI.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderCustom extends BCryptPasswordEncoder {
    Integer STRENGTH_ENCODER = 12;

    public EncoderCustom() {
    }
}



