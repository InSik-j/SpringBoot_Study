package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

// PostConstruct 와 PreDestory
// @PostConstruct - Been이 준비되는 대로, 의존성을 연결하는 대로 초기화
// @PreDestroy - 컨테이너에서 Bean이 삭제되기 전에, application context에서 삭제되기 전에 
@Component
class SomeClass{
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All deoendencies are ready!");
	}
	
	// Been이 준비되는 대로, 의존성을 연결하는 대로 초기화
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy
	public void cleanup() {
		System.out.println("CleanUp");
	}
}

@Component
class SomeDependency{

	public void getReady() {
		System.out.println("Some logic using SomeDependency");
		
	}
	
}

@Configuration
@ComponentScan
public class PrePostAnnotationsSpringContextLuncherApplication {

	public static void main(String[] args) {
		
		
		try(var context = new AnnotationConfigApplicationContext
								(PrePostAnnotationsSpringContextLuncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}

	}

}
