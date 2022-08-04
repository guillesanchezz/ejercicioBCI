package com.exerciseBCI.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ErrorsDTO {

    private List<ErrorDTO> error = new ArrayList<>();

}
