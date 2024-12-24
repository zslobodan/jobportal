package com.slobodanzivanovic.jobportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

	@GetMapping("/register")
	public String register() {
		return "register";
	}
}
