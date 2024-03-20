package com.in28minutes.learnspringframework.examples.c1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// Beans의 지연 초기화 & 즉시 초기화
// Spring Bean의 기본 초기화는 즉시 초기화
// 즉시 초기화를 사용하면 오류 확인이 쉬움
// @Lazy 지연 초기화
//  - @Component와 @Bean이 사용되는 거의 모든 곳에서 사용 가능, 권장 x
//  - Application이 시작될 때 Spring 구성 오류를 발견할 수 없음

@Component
class ClassA{ // Bean을 생성하는 Class
	
}

@Component
@Lazy
class ClassB{ // ClassA Bean을 사용하여 초기화하는 클래스
	
	private ClassA classA; // 의존성 정의
	
	public ClassB(ClassA classA) {
		
		// Logic
		System.out.println("Some Initialization Logic");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do Something");
	}
}


@Configuration
@ComponentScan
public class RealWorldSpringContextLuncherApplication {

	public static void main(String[] args) {
		
		
		try(var context = new AnnotationConfigApplicationContext
								(RealWorldSpringContextLuncherApplication.class)){
			System.out.println("Initialization of context is completed");
			
			context.getBean(ClassB.class).doSomething();
		}

	}

}
