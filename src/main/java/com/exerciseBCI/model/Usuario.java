package com.exerciseBCI.model;

public class Usuario {
	private String name;
	private String email;
	private String password;
	
	
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Usuario(String name, String email, String password) {
		super();
		this.setName(name);
		this.setEmail(email);
		this.setPassword(password);
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	
		
}