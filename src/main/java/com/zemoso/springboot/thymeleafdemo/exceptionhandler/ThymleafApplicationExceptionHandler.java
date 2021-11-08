package com.zemoso.springboot.thymeleafdemo.exceptionhandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ThymleafApplicationExceptionHandler {
	
	
	
	    @ExceptionHandler
	    public String handleException(StudentNotFoundException exception){
	        return "errors/student-not-found";
	    }

	    @ExceptionHandler
	    public String handleException(DepartmentNotFoundException exception){
	        return "errors/department-not-found";
	    }
	    
	}


