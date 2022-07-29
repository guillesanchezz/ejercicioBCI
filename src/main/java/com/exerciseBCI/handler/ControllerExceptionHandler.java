package com.exerciseBCI.handler;

import com.exerciseBCI.dto.ErroresDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.exerciseBCI.dto.ErrorDTO;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(EmailViolationException.class)
    protected ResponseEntity<ErroresDTO> handleException(EmailViolationException ex) {
    	return buildResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST); 
    }
	
	 @ExceptionHandler(ValidationException.class)
	    protected ResponseEntity<ErroresDTO> handleException(ValidationException ex) {
	    	return buildResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST); 
	    }
	 
	 @ExceptionHandler(UsuarioNotFoundException.class)
	    protected ResponseEntity<ErroresDTO> handleExceptionNotFound(UsuarioNotFoundException ex) {
	    	return buildResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND); 
	    }
	 
	 @ExceptionHandler(PasswordIncorrectException.class)
	    protected ResponseEntity<ErroresDTO> handleException(PasswordIncorrectException ex) {
	    	return buildResponseEntity(ex.getMessage(), HttpStatus.FORBIDDEN);
	    }
	
	@ExceptionHandler(Exception.class)
	    protected ResponseEntity<ErroresDTO> handleException(Exception ex) {
	    	return buildResponseEntity("Unexpected error", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
		
	 private ResponseEntity<ErroresDTO> buildResponseEntity(String msg, HttpStatus status) {
		 ErrorDTO errorDTO = new ErrorDTO(LocalDateTime.now(), status.value(), msg);
		 ErroresDTO erroresDTO = new ErroresDTO();
		 erroresDTO.getError().add(errorDTO);
	    	return new ResponseEntity<>(erroresDTO,status);
	        
	    }
}
