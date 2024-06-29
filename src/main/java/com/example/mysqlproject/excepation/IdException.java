package com.example.mysqlproject.excepation;

import org.springframework.http.HttpStatus;

public class IdException {
	
	private final String message;
	private final Throwable cause;
	private final HttpStatus httpStatus;
	
	public IdException(String message, Throwable cause, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.cause = cause;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public Throwable getCause() {
		return cause;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	

}
