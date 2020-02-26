package com.phegion.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.phegion.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		
		HttpStatus sts = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), sts.value(), "Nao encontrado" , e.getMessage(), request.getRequestURI()); 
		return ResponseEntity.status(sts).body(err);
	}
}