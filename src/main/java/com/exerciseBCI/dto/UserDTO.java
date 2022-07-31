package com.exerciseBCI.dto;

import com.exerciseBCI.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.List;

public class UserDTO extends RequestDTO {
	private String id;
	private LocalDateTime created;
	private LocalDateTime modified;
	private LocalDateTime lastLogin;
	private String token;
	private Boolean isActive;
	
	public UserDTO(String name, String email, String password, List<PhoneDTO> phones,
				   String id, LocalDateTime created, LocalDateTime modified, LocalDateTime lastLogin, String token, Boolean isActive) {
			super(name, email, password, phones);
			this.id = id;
			this.created = created;
			this.modified = modified;
			this.lastLogin = lastLogin;
			this.token = token;
			this.isActive = isActive;
	}

	public static UserDTO from(UserEntity userEntity, String token){
		return new UserDTO(
				userEntity.getName(),
				userEntity.getEmail(),
				userEntity.getPassword(),
				PhoneDTO.from(userEntity.getPhones()),
				userEntity.getId().toString(),
				userEntity.getCreated(),
				userEntity.getModified(),
				userEntity.getLastLogin(),
				token,
				userEntity.getIsActive());
	}

	public String getId() {
		return id;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public String getToken() {
		return token;
	}

	public Boolean getActive() {
		return isActive;
	}
}
