package com.angang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestTransaction {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void testInsert() {
		System.out.println("执行插入操作");
		jdbcTemplate.execute("INSERT INTO `spring_study`.`t1` (`a`, `b`, `c`, `d`) VALUES ('1', '1', '1', '1')");
//		throw new NullPointerException();
		//这种情况 两条数据都会插入成功 因为执行testInsert1的对象是testTransaction的普通对象 而不是代理对象testInsert1上面的注解不生效
		//要想实现这种事物中嵌套事物 可以有两种方法：
		//1. 把testInsert1放到另外一个service中 在此service中注入另一个service
		//2. 此service自己注入自己 再通过自己调用另外一个方法
		this.testInsert1();
	}

	@Transactional(propagation = Propagation.NEVER)
	public void testInsert1() {
		System.out.println("执行插入操作1");
		jdbcTemplate.execute("INSERT INTO `spring_study`.`t1` (`a`, `b`, `c`, `d`) VALUES ('2', '2', '2', '2')");
	}
}
