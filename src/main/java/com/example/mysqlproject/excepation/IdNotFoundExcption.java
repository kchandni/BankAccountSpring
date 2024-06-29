package com.example.mysqlproject.excepation;

public class IdNotFoundExcption extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public IdNotFoundExcption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IdNotFoundExcption(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	

}
