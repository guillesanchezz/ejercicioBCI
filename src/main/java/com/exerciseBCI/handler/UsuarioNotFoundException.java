package com.exerciseBCI.handler;

import java.util.Objects;

public class UsuarioNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE_DEFAULT = "Usuario not Found";
	
	@Override
	public String getMessage() {
		if(Objects.nonNull(super.getMessage())){
			return super.getMessage();
		}
		return MESSAGE_DEFAULT;
	}
}
