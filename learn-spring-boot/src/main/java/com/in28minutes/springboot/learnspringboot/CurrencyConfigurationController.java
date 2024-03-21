package com.in28minutes.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {
	
	@Autowired
	private CurrencyServiceConfiguragion configuragion;
	
	@RequestMapping("/currency-configuration")
	public CurrencyServiceConfiguragion retrieveAllCourses(){
		return configuragion;
	}
	
}
