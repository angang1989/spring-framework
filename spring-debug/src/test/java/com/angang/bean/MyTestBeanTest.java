package com.angang.bean;

import com.angang.AppConfig;
import com.angang.service.TestTransaction;
import com.angang.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

import static org.assertj.core.api.Assertions.assertThat;

public class MyTestBeanTest {

	@Test
	void testSimpleLoad() {
//		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("springTestBean.xml"));

		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		AbstractBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		int loadBeanCount = reader.loadBeanDefinitions("springTestBean.xml");

		System.out.println("加载bean的数量=" + loadBeanCount);

		MyTestBean bean = (MyTestBean) factory.getBean("testBean");

		System.out.println(bean.getTestStr());

		assertThat(bean.getTestStr().equals("testStr"));
	}

}
