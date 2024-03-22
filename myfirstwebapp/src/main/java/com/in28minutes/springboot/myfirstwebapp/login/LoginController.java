package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	private AuthonticationService autheAuthonticationService;
	
	public LoginController(AuthonticationService autheAuthonticationService) {
		super();
		this.autheAuthonticationService = autheAuthonticationService;
	}
	

	@RequestMapping(value="login", method = RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, 
								  @RequestParam String password,
								  ModelMap model) {
		model.put("name", name);
		model.put("password", password);
		
		if(autheAuthonticationService.authenticate(name, password)) {
			
			return "welcome";
		}
		
		model.put("errorMessage", "Invalid Credentials! Pleas Try Again");
		
		return "login";
	}
}
