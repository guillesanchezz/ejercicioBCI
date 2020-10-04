package com.exerciseBCI.dto;

public class LoginDTO {
	private String user;
	private String pass;
	
	public LoginDTO() {
		super();
	}

	public LoginDTO(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
