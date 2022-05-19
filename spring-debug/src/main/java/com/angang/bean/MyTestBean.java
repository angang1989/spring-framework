package com.angang.bean;

import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class MyTestBean {
	private String testStr = "testStr";

	public String getTestStr() {
		return this.testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	public static void main(String[] args) {
		//BeanFactory factory = new XmlBeanFactory(new ClassPathResource("springTestBean.xml"));

		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		AbstractBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		int loadBeanCount = reader.loadBeanDefinitions("springTestBean.xml");

		System.out.println("加载bean的数量=" + loadBeanCount);

		MyTestBean bean = (MyTestBean) factory.getBean("testBean");

		System.out.println(bean.getTestStr());
	}
}
