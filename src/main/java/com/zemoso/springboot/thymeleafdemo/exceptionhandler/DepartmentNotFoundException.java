package com.zemoso.springboot.thymeleafdemo.exceptionhandler;

public class DepartmentNotFoundException extends RuntimeException{

	public DepartmentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public DepartmentNotFoundException(String message) {
		super(message);
	
	}

	public DepartmentNotFoundException(Throwable cause) {
		super(cause);
	
	}

	
}
