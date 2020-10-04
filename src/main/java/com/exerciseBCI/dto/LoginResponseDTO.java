package com.exerciseBCI.dto;

public class LoginResponseDTO {
	private String token;

	public LoginResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginResponseDTO(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
