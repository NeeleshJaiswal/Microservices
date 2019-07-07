package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
			
		ExceptionResponse exceptionResponse= new ExceptionResponse("Exception for all", request.getDescription(false), new Date());
		System.out.println("Exception for all");
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
			
		ExceptionResponse exceptionResponse= new ExceptionResponse("UserNotFoundException for all", request.getDescription(false), new Date());
		 System.out.println("UserNotFoundException for all");
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		ExceptionResponse exceptionResponse=new ExceptionResponse("Validation Failed", ex.getBindingResult().getAllErrors().toString(), new Date());
		System.out.println("handleMethodArgumentNotValid for all");
		return new ResponseEntity<Object>(exceptionResponse, status.BAD_REQUEST);
	}
}
