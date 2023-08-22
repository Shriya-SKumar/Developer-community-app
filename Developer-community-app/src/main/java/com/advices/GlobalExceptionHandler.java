package com.advices;
import java.time.LocalDateTime;
//import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(UnknownDeveloperException.class)
    public ResponseEntity<?> resourceNotFoundException(UnknownDeveloperException ex, WebRequest request) 
	{
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(UserNotFoundException ex, WebRequest request) 
	{
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UnknownFeedException.class)
	public ResponseEntity<?> resourceNotFoundException(UnknownFeedException ex, WebRequest request) 
	{
	       ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	       return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UnknownResourceException.class)
	public ResponseEntity<?> resourceNotFoundException(UnknownResourceException ex, WebRequest request) 
	{
	       ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	       return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class) 
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) 
	{ 
		  ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); 
	      return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR); 
	 }

}

