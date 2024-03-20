package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//  컴포넌트 @Component
//  - 수동으로 Bean을 생성하지 않아도 Spring framework에서 대신 생성
//  - 1. 해당 클래스에 @Component 추가
//  - 2. 연결할 클래스에 @ComponentScan("") 경로 지정

// 여러개 생성시 우선순위 @Qualifier > @Primary

// @Primary와 @Qualifier를 사용해야 하는 경우
// @Primary   : 여러 후보가 자격이 있는 경우에 해당 Bean에게 우선권을 줄 경우
// @Qualifier : 특정하게 지정된 Bean을 자동 와이어링 해야 할 경우

// 의존성 주입의 3가지 유형
// 생성자 Constructor 기반
// 수정자 Setter 기반 - Setter 메소드를 사용
// 필드 기반 - 리플렉션을 이용하여 의존성 주입

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class GamingAppLuncherApplication {

	public static void main(String[] args) {
		
		
		try(var context = new AnnotationConfigApplicationContext
								(GamingAppLuncherApplication.class)){
			context.getBean(GammingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
		}

	}

}
