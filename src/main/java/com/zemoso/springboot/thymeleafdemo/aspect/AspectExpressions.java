/**/package com.zemoso.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectExpressions {
	 private static Logger myLogger= LoggerFactory.getLogger(AspectExpressions.class.getName());
	
	@After("execution(* com.zemoso.springboot.thymeleafdemo.service.*.save*(..))")
	public void saveAspect(JoinPoint joinPoint)
			{
				
				myLogger.info("-->Executing  after advice method");
		        //display the method signature
		        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();

		        myLogger.info("Method : "+methodSignature);
				
			}
	@Before("execution(* com.zemoso.springboot.thymeleafdemo.service.*.*(..))")
	public void all(JoinPoint joinPoint)
			{
				
				
				myLogger.info("-->Executing  before advice method");
		        //display the method signature
		        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();

		        myLogger.info("Method : "+methodSignature);

			}

}
