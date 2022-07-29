package com.exerciseBCI.dto;

import java.time.LocalDateTime;
import java.util.List;

public class UsuarioDTO extends RegistroDTO {
	private String id;
	private LocalDateTime created;
	private LocalDateTime modified;
	private LocalDateTime lastLogin;
	private String token;
	private Boolean isActive;
	
	public UsuarioDTO() {
		super();
	}
	
	public UsuarioDTO(String name, String email, String password, List<PhoneDTO> phones,
					  String id, LocalDateTime created, LocalDateTime modified, LocalDateTime lastLogin, String token, Boolean isActive) {
			super(name, email, password, phones);
			this.id = id;
			this.created = created;
			this.modified = modified;
			this.lastLogin = lastLogin;
			this.token = token;
			this.isActive = isActive;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
