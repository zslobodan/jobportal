package com.slobodanzivanovic.jobportal.controller;

import com.slobodanzivanovic.jobportal.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class JobPostActivityController {

	private final UsersService usersService;

	@GetMapping("/dashboard/")
	public String searchJobs(Model model) {
		Object currentUserProfile = usersService.getCurrentUserProfile();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (!(currentUserProfile instanceof AnonymousAuthenticationToken)) {
			String currentUsername = authentication.getName();

			model.addAttribute("username", currentUsername);
		}
		model.addAttribute("user", currentUserProfile);

		return "dashboard";
	}
}
