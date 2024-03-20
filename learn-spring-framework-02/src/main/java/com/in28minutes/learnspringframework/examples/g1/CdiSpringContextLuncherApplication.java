package com.in28minutes.learnspringframework.examples.g1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;


// CDI
// Spring Annotation 대체해서 사용 가능 
// @Component -> @named
// @Autowired -> @Inject


//@Component
@Named
class BusinessService{
	private DataService dataService;
	
	public DataService getDataService() {
		return dataService;
	}
	
	//@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter-Injection");
		this.dataService = dataService;
	}
	
}

//@Component
@Named
class DataService{
	
}

@Configuration
@ComponentScan
public class CdiSpringContextLuncherApplication {

	public static void main(String[] args) {
		
		
		try(var context = new AnnotationConfigApplicationContext
								(CdiSpringContextLuncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessService.class).getDataService());
		}

	}

}
