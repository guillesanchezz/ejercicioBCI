package com.exerciseBCI.handler;

import java.util.Objects;

public class PasswordValidationException extends ValidationException {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE_DEFAULT = "Password invalid";
	
	@Override
	public String getMessage() {
		if(Objects.nonNull(super.getMessage())){
			return super.getMessage();
		}
		return MESSAGE_DEFAULT;
	}
}
