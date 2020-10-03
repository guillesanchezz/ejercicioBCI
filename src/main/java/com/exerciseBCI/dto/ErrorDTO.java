package com.exerciseBCI.dto;

import java.util.Objects;

public class ErrorDTO {
	
	private static final String  DEFAULT_MESSAGE = "Unexpected error";  
	
	private String message;
	
	public ErrorDTO() {
    	super();
    }
	
	public ErrorDTO(String message) {
    	super();
    	this.message = message;
    }
	
	public String getMessage() {
    	if(Objects.nonNull(this.message)) {
    		return this.message;
    	}
    	return DEFAULT_MESSAGE;
    }
}
