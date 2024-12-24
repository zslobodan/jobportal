package com.slobodanzivanovic.jobportal.controller;

import com.slobodanzivanovic.jobportal.entity.Users;
import com.slobodanzivanovic.jobportal.entity.UsersType;
import com.slobodanzivanovic.jobportal.services.UsersService;
import com.slobodanzivanovic.jobportal.services.UsersTypeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class UsersController {

	private final UsersTypeService usersTypeService;

	private final UsersService usersService;

	@GetMapping("/register")
	public String register(Model model) {
		List<UsersType> usersTypes = usersTypeService.getAll();
		model.addAttribute("getAllTypes", usersTypes);
		model.addAttribute("user", new Users());

		return "register";
	}

	@PostMapping("/register/new")
	public String userRegistration(@Valid Users users) {
		usersService.addNew(users);

		return "dashboard";
	}
}
