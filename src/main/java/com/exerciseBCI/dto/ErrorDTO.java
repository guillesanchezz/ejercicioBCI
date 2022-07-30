package com.exerciseBCI.dto;

import java.time.LocalDateTime;

public class ErrorDTO {

    private final LocalDateTime timestamp;
    private final Integer code;
    private final String detail;

    public ErrorDTO(LocalDateTime timestamp, Integer code, String detail) {
        super();
        this.timestamp = timestamp;
        this.code = code;
        this.detail = detail;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Integer getCode() {
        return code;
    }

    public String getDetail() {
        return detail;
    }
}
