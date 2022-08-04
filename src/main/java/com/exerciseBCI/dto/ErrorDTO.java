package com.exerciseBCI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class ErrorDTO {

    private final LocalDateTime timestamp;
    private final Integer code;
    private final String detail;
}
