package com.exerciseBCI.handler;

import java.util.Objects;

public class PasswordIncorrectException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE_DEFAULT = "Password Incorrect";
	
	@Override
	public String getMessage() {
		if(Objects.nonNull(super.getMessage())){
			return super.getMessage();
		}
		return MESSAGE_DEFAULT;
	}
}
