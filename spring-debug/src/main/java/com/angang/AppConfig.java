package com.angang;

import com.angang.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@ComponentScan("com.angang")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Configuration //要启用事物 需要加上此注解
public class AppConfig {

	/**
	 * 此时spring容器中 会有三个orderService对象 beanName分别是：orderService,orderService1,orderService2
	 * Component注解和Bean注解是不冲突的
	 */
	@Bean
	public OrderService orderService1() {
		return new OrderService();
	}

	@Bean
	public OrderService orderService2() {
		return new OrderService();
	}

	//这里的jdbcTemplate,platformTransactionManager,dataSource都要被spring管理
	@Bean
	public JdbcTemplate jdbcTemplate () {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public PlatformTransactionManager platformTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/spring_study?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("angang1989");
		return dataSource;
	}
}
