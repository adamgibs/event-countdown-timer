package com.gibson.springboot.crudapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gibson.springboot.crudapp.entity.User;
import com.gibson.springboot.crudapp.service.UserServiceImpl;



@Controller
public class LoginController {
	UserServiceImpl srv;
	
	@Autowired
	public LoginController(UserServiceImpl srv) {
		this.srv = srv;
	}
	
	@GetMapping("/")
	public String showMyLoginPage(Model model) {
		model.addAttribute("user", new User());
		System.out.println("Hello");
		return "login";
		
	}
	
	
	@PostMapping("/login")
	public String loginSubmit(@ModelAttribute User user, Model model) {
		String username = user.getUsername();
		String password = user.getPassword();
		System.out.println(username + " " + password);
		Boolean userExists = srv.checkIfUserExists(username);
		
		if(userExists) {
			return "home";
		}
		
		model.addAttribute("errorMsg", "User not found");
		return "login";
	}
		
//		User user = new User();
//		
//		//No username or password included in request
//		if(userName == null || password == null) {
//			String message = "Please input a message";
//			request.setAttribute("errorMessage", message);
//			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
//		}
//		
//		//Message is nothing but white space or left blank
//		if(userName.trim().length() == 0 || password.trim().length() == 0) {				
//
//			String message = "Please input a message";
//			request.setAttribute("errorMessage", message);
//			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
//			
//		}		
//		
//		user = userManager.getUserByLogin(userName, password);
//		
//		if (userExists == false) {
//			String message = "Invalid username and/or password";						
//				request.setAttribute("errorMessage", message);
//				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
//			
//		}
//		else { 			
//			
//			Cookie cookie = new Cookie("userId",userName);
//			response.addCookie(cookie);
//			
//			 response.sendRedirect("/y-enterprises/main");
//			
//		}
		
		// add request mapping for /access-denied
		
		@GetMapping("/access-denied")
		public String showAccessDenied() {
			
			return "access-denied";
			
		}
	
}
