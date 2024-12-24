package com.slobodanzivanovic.jobportal.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class UsersController {

	@GetMapping("/register")
	public String register() {
		return "register";
	}
}
