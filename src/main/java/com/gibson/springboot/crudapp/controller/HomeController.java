package com.gibson.springboot.crudapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class HomeController {

	@RequestMapping(value = "/") 
	public String login() {
		return "login"; 
	}
	
	@RequestMapping(value = "/index") 
	public String index() {
		return "index"; 
	}


}
