package com.example.springpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringPracticeApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(SpringPracticeApplication.class, args);
		displayAllBeans(ac);
	}

	public static void displayAllBeans(ApplicationContext ac) {
		String[] allBeanNames = ac.getBeanDefinitionNames();
		for (String beanName : allBeanNames) {
			System.out.println(beanName);
		}
	}
}
