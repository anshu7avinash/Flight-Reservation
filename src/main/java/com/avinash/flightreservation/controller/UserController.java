package com.avinash.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.avinash.flightreservation.entities.User;
import com.avinash.flightreservation.repos.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/showReg")
	public String showRegistrationPage(){
		return "login/registerUser";
	}
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public String register(@ModelAttribute("user")User user){
		userRepository.save(user);
		return "login/login";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage(){
		return "login/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("email") String email,@RequestParam("password") String password,ModelMap modelMap ){
		User user = userRepository.findByEmail(email);
		if(user.getPassword().equals(password)){
			return "findFlights";
		}else{
			modelMap.addAttribute("msg","Invalid UserName or Password. Please try Again later.");
		}
		return "login/login";
	}
	
	@RequestMapping("/directLogin")
	public String directLogin(){
		return "login/login";
	}
	
	
	
}
