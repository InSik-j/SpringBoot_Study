package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// Spring Been 정의 가능.
// Spring Been : Spring에서 관리하는 것. 
//				 Spring에서 관리하는 것은 무엇이든 Bean이 될 수 있음
//				 context.getBean을 사용하고 이름을 부여하거나 검색이 가능
//				 been 이름을 필요에 따라 지정할 수 있음
// Configuration 클래스에서 method를 정의하여 Spring Bean 생성
//                       클래스에 정의하여 컴포넌트 생성

// Q. Spring Container란?
// A. Spring Been과 수명 주기를 관리

// Q. Spring이 관리하는 Been 프레임워크를 모두 나열하는 방법
// A. Context 요청 ex) context.getBeanDefinitionNames() or Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

// Q. 일치하는 여러 개의 Been을 사용할 수 있다면?
// A. 여러 개의 Been 중 하나를 기본(@Primary)으로 생성하거나 한정자(@Qualifier)로 생성

// record를 사용하면 getter, setter 생성할 필요 X
record Person(String name, int age, Address address) {};
record Address(String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {

	
	// Spring에 Been을 관리하라는 명령 내리기
	
	// 객체 관리
	@Bean
	public String name() {
		return "Ranga";
	}
	
	@Bean
	public int age() {
		return 35;
	}
	
	@Bean
	public Person person() {
		//var person = new Person("Ravi", 20);
		return new Person("Ravi", 20, new Address("Main Streed", "Utrecht"));
	}
	
	
	// 기존 Been과 관계가 있는 새로운 Been 생성
		// 1. method 호출
	@Bean
	public Person person2MethodCall() {
		//var person = new Person("Ravi", 20);
		return new Person(name(), age(), address()); // name, age
	}
		// 2. 매개변수 추가
	@Bean
	public Person person3Parameters(String name, int age, Address address3) { // name, age, address2
		//var person = new Person("Ravi", 20);
		return new Person(name, age, address3); // name, age
	}
	
	@Bean
	@Primary
	public Person person4Parameters(String name, int age,  Address address) { // name, age, address2
		//var person = new Person("Ravi", 20);
		return new Person(name, age, address); // name, age
	}
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) { // name, age, address2
		//var person = new Person("Ravi", 20);
		return new Person(name, age, address); // name, age
	}
	
	
	//been 이름을 필요에 따라 지정할 수 있음
	@Bean(name = "address2")
	@Primary
	public Address address() {
		return new Address("Baker Streed", "London");
	}
	
	@Bean(name = "address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		return new Address("Motinagar", "Hyderabad");
	}
}
