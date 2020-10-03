package com.exerciseBCI.dto;

import java.util.List;

public class RegistroDTO {
	private String name;
	private String email;
	private String password;
	private List<PhoneDTO> phones;
	
	public RegistroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistroDTO(String name, String email, String password, List<PhoneDTO> phones) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
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

	public List<PhoneDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}
	
	
	
}
