package com.example.mysqlproject.excepation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AccountExceptionHandler {
	
	@ExceptionHandler(value=IdNotFoundExcption.class)
	public ResponseEntity<Object> handlerException(IdNotFoundExcption idNotFoundException)
	{
		IdException idException=new IdException(idNotFoundException.getMessage(),idNotFoundException.getCause(),HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(idException,HttpStatus.NOT_FOUND);
	

   }
}
