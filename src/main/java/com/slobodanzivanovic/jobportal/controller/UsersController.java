package com.slobodanzivanovic.jobportal.controller;

import com.slobodanzivanovic.jobportal.entity.Users;
import com.slobodanzivanovic.jobportal.entity.UsersType;
import com.slobodanzivanovic.jobportal.services.UsersTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class UsersController {

	private final UsersTypeService usersTypeService;

	@GetMapping("/register")
	public String register(Model model) {
		List<UsersType> usersTypes = usersTypeService.getAll();
		model.addAttribute("getAllTypes", usersTypes);
		model.addAttribute("user", new Users());

		return "register";
	}
}
