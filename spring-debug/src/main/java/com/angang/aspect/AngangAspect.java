package com.angang.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AngangAspect {

	@Before("execution(public void com.angang.service.UserService.test())")
	public void before(JoinPoint joinPoint) {
		System.out.println("切面 before");
	}
}
