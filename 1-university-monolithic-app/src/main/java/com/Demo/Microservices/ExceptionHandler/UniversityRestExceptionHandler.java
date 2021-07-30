package com.Demo.Microservices.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Demo.Microservices.customException.UniversityNotFoundException;
import com.Demo.Microservices.errorResponse.UniversityErrorResponse;

@ControllerAdvice
public class UniversityRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<?> handleException(UniversityNotFoundException exc) {
		UniversityErrorResponse error = new UniversityErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<?> handleException(NumberFormatException exc) {
		UniversityErrorResponse error = new UniversityErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Please provide valid value");
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<?> handleException(Exception exc) {
		UniversityErrorResponse error = new UniversityErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
