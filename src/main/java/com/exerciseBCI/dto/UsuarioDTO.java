package com.exerciseBCI.dto;

import java.util.Date;
import java.util.List;

public class UsuarioDTO extends RegistroDTO {
	private Integer id;
	private Date created;
	private Date modified;
	private Date lastLogin;
	private String token;
	private Boolean isActive;
	
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioDTO(String name, String email, String password, List<PhoneDTO> phones,
			Integer id, Date created, Date modified, Date lastLogin, String token, Boolean isActive) {
			super(name, email, password, phones);
			this.id = id;
			this.created = created;
			this.modified = modified;
			this.lastLogin = lastLogin;
			this.token = token;
			this.isActive = isActive;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
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
