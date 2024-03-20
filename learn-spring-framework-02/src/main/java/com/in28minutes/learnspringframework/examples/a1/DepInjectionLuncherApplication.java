package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.Context;

// 의존성 주입의 3가지 유형
// 생성자 Constructor 기반 - 자동 와이어링이 의무가 아니고 모든 초기화가 한 메소드에서 이뤄지는 것이 장점, 
// 수정자 Setter 기반 - Setter 메소드를 사용
// 필드 기반 - 리플렉션을 이용하여 의존성 주입, Constructor, Setter가 없음 


//Dependency1, Dependency2 2개의 의존성이 있는 YourBusinessClass에 Constructor 기반 의존성 주입하기
@Component
class YourBusinessClass{
	
	Dependency1 dependency1;

	Dependency2 dependency2;
	
	// @Autowired을 추가하지 않아도 Constructor를 생성한다면 Spring에서 자동으로 Constructor를 사용해서 객채를 생성해줌
	//@Autowired					 // 생성자		         // 생성자   
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor Injection - YourBusinessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	public String toString() {
		return "Using " + dependency1 + " and " + dependency2;
	}
}

/*
//Dependency1, Dependency2 2개의 의존성이 있는 YourBusinessClass에 Setter 기반 의존성 주입하기
@Component
class YourBusinessClass{
	
	Dependency1 dependency1;

	Dependency2 dependency2;

	@Autowired
	public void setDependency1(Dependency1 dependency1) {
		System.out.println("Setter Injection - setDependency1");
		this.dependency1 = dependency1;
	}
	@Autowired
	public void setDependency2(Dependency2 dependency2) {
		System.out.println("Setter Injection - setDependency2");
		this.dependency2 = dependency2;
	}

	public String toString() {
		return "Using " + dependency1 + " and " + dependency2;
	}
}
*/

/*
//Dependency1, Dependency2 2개의 의존성이 있는 YourBusinessClass에 필드 기반 의존성 주입하기
@Component
class YourBusinessClass{
	@Autowired
	Dependency1 dependency1;
	
	@Autowired
	Dependency2 dependency2;
	
	public String toString() {
		return "Using " + dependency1 + " and " + dependency2;
	}
}
*/

@Component
class Dependency1{
	
}
@Component
class Dependency2{
	
}

@Configuration
@ComponentScan
public class DepInjectionLuncherApplication {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext
								(DepInjectionLuncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(YourBusinessClass.class));
		}
		
	}

}

