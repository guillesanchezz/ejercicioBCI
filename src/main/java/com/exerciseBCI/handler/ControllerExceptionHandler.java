package com.exerciseBCI.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.exerciseBCI.dto.ErrorDTO;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(EmailViolationException.class)
    protected ResponseEntity<ErrorDTO> handleException(EmailViolationException ex) {
    	return buildResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST); 
    }
	
	 @ExceptionHandler(ValidationException.class)
	    protected ResponseEntity<ErrorDTO> handleException(ValidationException ex) {
	    	return buildResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST); 
	    }
	 
	 @ExceptionHandler(UsuarioNotFoundException.class)
	    protected ResponseEntity<ErrorDTO> handleExceptionNotFound(UsuarioNotFoundException ex) {
	    	return buildResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND); 
	    }
	 
	 @ExceptionHandler(PasswordIncorrectException.class)
	    protected ResponseEntity<ErrorDTO> handleException(PasswordIncorrectException ex) {
	    	return buildResponseEntity(ex.getMessage(), HttpStatus.FORBIDDEN);
	    }
	
	@ExceptionHandler(Exception.class)
	    protected ResponseEntity<ErrorDTO> handleException(Exception ex) {
	    	return buildResponseEntity("Unexpected error", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
		
	 private ResponseEntity<ErrorDTO> buildResponseEntity(String msg, HttpStatus status) {
	    	return new ResponseEntity<>(new ErrorDTO(msg),status);
	        
	    }
}
