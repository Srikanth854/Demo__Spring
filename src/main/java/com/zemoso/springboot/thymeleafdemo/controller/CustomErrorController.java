package com.zemoso.springboot.thymeleafdemo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {
		@GetMapping("/error")
		public String handleError(HttpServletRequest request) {
			String errorPage = "error";
			Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
			
			if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				System.out.println(request);
				System.out.println(status);
				errorPage = "errors/404";
			}
				else if (statusCode == HttpStatus.FORBIDDEN.value()) {
				errorPage = "errors/403";
				}
				else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				errorPage = "errors/500";
				}
				else if(statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()){
					errorPage="errors/405";
				}
				
			}
			return errorPage;
}
	public String getErrorPath() {
			return "/error";
			}

}
