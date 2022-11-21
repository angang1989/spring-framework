package com.angang.bean;

import com.angang.AppConfig;
import com.angang.service.TestTransaction;
import com.angang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		//bean对象
//		UserService userService = (UserService) applicationContext.getBean("userService");
//		userService.test();

//		//怎么去依赖注入的
//		UserService userService1 = new UserService();
//		for (Field field : userService1.getClass().getDeclaredFields()) {
//			if(field.isAnnotationPresent(Autowired.class)) {
//				field.set(userService1, XX);
//			}
//		}
//
//		//postConstruct
//		for (Method method : userService1.getClass().getDeclaredMethods()) {
//			if(method.isAnnotationPresent(PostConstruct.class)) {
//				method.invoke(userService1, null);
//			}
//		}

		//测试事物
		TestTransaction testTransaction = (TestTransaction) applicationContext.getBean("testTransaction");
		testTransaction.testInsert();
	}
}
