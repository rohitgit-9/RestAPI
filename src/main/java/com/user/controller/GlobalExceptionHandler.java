package com.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.user.NoSuchUserException;
import com.user.NoUserFound;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NoSuchUserException.class)
	public ResponseEntity<Object> noSuchUserFound(NoSuchUserException ex) {
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoUserFound.class)
	public ResponseEntity<Object> noSuchNoUserFound(NoUserFound ex) {
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.CONFLICT);
	}

//	@ExceptionHandler(value = NoSuchUserException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	public @ResponseBody ErrorResponse handleException(NoSuchUserException ex) {
//		return new ErrorResponseException(HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value()), ex);
//	}
//	@
}
