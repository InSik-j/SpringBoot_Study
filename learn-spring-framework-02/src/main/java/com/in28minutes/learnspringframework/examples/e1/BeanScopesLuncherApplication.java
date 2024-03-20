package com.in28minutes.learnspringframework.examples.e1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Bean을 만들 수 있는 다양한 Scopes

// Spring에서 생성되는 모든 Bean의 기본값은 Singleton
// - 요청할 때마다 context에서 같은 인스턴스 반환
// - Spring IoC 컨테이너당 객체 인스턴스가 1개
// PrototypeClass
// - 매번 context에서 새로운 Bean을 가져옴 (요청할 때마다 context에서 새로운 인스턴스 반환)
// - Spring IoC 컨테이너당 객체 인스턴스가 여러개

@Component
class NormalClass{
	
}

@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass{
	
}

@Configuration
@ComponentScan
public class BeanScopesLuncherApplication {

	public static void main(String[] args) {
		
		
		try(var context = new AnnotationConfigApplicationContext
								(BeanScopesLuncherApplication.class)){
			
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			
		}

	}

}
