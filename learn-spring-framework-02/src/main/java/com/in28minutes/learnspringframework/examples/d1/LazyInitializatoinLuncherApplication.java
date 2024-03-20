package com.in28minutes.learnspringframework.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// 의존성 주입의 3가지 유형
// 생성자 Constructor 기반
// 수정자 Setter 기반 - Setter 메소드를 사용
// 필드 기반 - 리플렉션을 이용하여 의존성 주입



@Configuration
@ComponentScan
public class LazyInitializatoinLuncherApplication {

	public static void main(String[] args) {
		
		
		try(var context = new AnnotationConfigApplicationContext
								(LazyInitializatoinLuncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}

	}

}
