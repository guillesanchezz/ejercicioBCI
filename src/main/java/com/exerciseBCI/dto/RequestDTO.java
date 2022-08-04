package com.exerciseBCI.dto;

import lombok.*;

import java.util.List;

@Getter @Setter @ToString
@AllArgsConstructor
@Builder
public class RequestDTO {

	private String name;
	private String email;
	private String password;
	private List<PhoneDTO> phones;

}
