package com.exerciseBCI.dto;

import com.exerciseBCI.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
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

}
