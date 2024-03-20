package com.in28minutes.learnspringframework.examples.c1;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class BusinessCalculationService {
	
	private DataService dataService;
	
	// 생성자 기반 의존성 주입
	public BusinessCalculationService(DataService dataService) {
		super();
		this.dataService = dataService;
	}
	
	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}
}
