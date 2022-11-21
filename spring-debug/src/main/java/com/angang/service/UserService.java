package com.angang.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
//public class UserService {
public class UserService implements InitializingBean {
	@Autowired
	private OrderService orderService;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 推断构造方法
	 * 如果userService有一个有参的构造方法 就算testService不加autowired注解 也能初始化testService
	 * 如果userService同时有一个无参的构造方法 则会调用无参的构造方法 testService就不会被初始化
	 * 如果userService同时有多个有参的构造方法 就回报错 NoSuchMethod
	 * 可以通过@Autowired注解指定要使用的构造方法
	 * 执行bean的构造方法时 由spring来完成的
	 * 前提是testService是一个bean 可以被spring扫描到
	**/
	private TestService testService;
	public UserService(TestService testService) {
		//如果testService是单例模式spring会从单例池中找testService的bean(先byType在byName) 要么找到一个 要么没有找到（报错）
		//如果testService是多例模式 就直接创建
		this.testService = testService;
		System.out.println("有参构造方法");
	}

//	public UserService() {
//		System.out.println("无参构造方法");
//	}

	private User admin;

	@PostConstruct
	public void dealAdmin() {
		//对user对象进行初始化前的操作
		System.out.println("初始化前 执行bean中执行的方法");
	}

	public void test() {
		System.out.println("userService的test方法");
		System.out.println("orderService=" + orderService);
		System.out.println("testService=" + testService);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//初始化时 执行方法
		System.out.println("初始化时 执行方法");
//		throw new NullPointerException();
	}
}
