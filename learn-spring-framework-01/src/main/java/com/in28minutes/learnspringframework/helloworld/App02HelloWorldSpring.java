package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		
		// 1. @Configuration 클래스로 Spring Context 실행 
		try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
			// 2. Spring에서 관리할 수 있도록 환경 설정 - @Configuration : 설정 클래스 생성 및 이름 등 모든 것을 정의 할 수 있는 곳
						// HelloWorldConfiguration 클래스를 생성하며 @Configuration 설정 
						// name 메소드 생성 - @Bean
						// context를 사용해 객체 가져오기
					
					// 3. Spring이 관리하는 Bean 검색
						//context.getBean("name"); // context에 객체 이름 부여
					System.out.println(context.getBean("name"));
					
					System.out.println(context.getBean("age"));
					
					System.out.println(context.getBean("person"));
					
					System.out.println(context.getBean("address2"));
					
					//System.out.println(context.getBean(Address.class)); // class를 전달 가능
					System.out.println(context.getBean(Person.class));
					
					System.out.println(context.getBean("person2MethodCall"));
					
					System.out.println(context.getBean("person3Parameters"));
					
					System.out.println(context.getBean("person5Qualifier"));
					
					Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		};
		
		
		
		
		
		
	}

}
