package com.exerciseBCI.handler;

import com.exerciseBCI.dto.ErrorsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.exerciseBCI.dto.ErrorDTO;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(EmailViolationException.class)
    protected ResponseEntity<ErrorsDTO> handleException(EmailViolationException ex) {
    	return buildResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST); 
    }
	
	 @ExceptionHandler(ValidationException.class)
	    protected ResponseEntity<ErrorsDTO> handleException(ValidationException ex) {
	    	return buildResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST); 
	    }
	 
	 @ExceptionHandler(UserNotFoundException.class)
	    protected ResponseEntity<ErrorsDTO> handleExceptionNotFound(UserNotFoundException ex) {
	    	return buildResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND); 
	    }
	 
	 @ExceptionHandler(PasswordIncorrectException.class)
	    protected ResponseEntity<ErrorsDTO> handleException(PasswordIncorrectException ex) {
	    	return buildResponseEntity(ex.getMessage(), HttpStatus.FORBIDDEN);
	    }
	
	@ExceptionHandler(Exception.class)
	    protected ResponseEntity<ErrorsDTO> handleException(Exception ex) {
	    	return buildResponseEntity("Unexpected error", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
		
	 private ResponseEntity<ErrorsDTO> buildResponseEntity(String msg, HttpStatus status) {
		 ErrorDTO errorDTO = new ErrorDTO(LocalDateTime.now(), status.value(), msg);
		 ErrorsDTO errorsDTO = new ErrorsDTO();
		 errorsDTO.getError().add(errorDTO);
	    	return new ResponseEntity<>(errorsDTO,status);
	    }
}
