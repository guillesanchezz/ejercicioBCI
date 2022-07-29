package com.exerciseBCI.dto;

import java.util.ArrayList;
import java.util.List;

public class ErroresDTO {

    private List<ErrorDTO> error = new ArrayList<>();

    public ErroresDTO() {

    }

    public List<ErrorDTO> getError() {
        return error;
    }

    public void setError(List<ErrorDTO> error) {
        this.error = error;
    }

}
