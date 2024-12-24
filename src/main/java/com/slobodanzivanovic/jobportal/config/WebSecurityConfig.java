package com.slobodanzivanovic.jobportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

	private final String[] publicUrl = {
		"/",
		"/global-search/**",
		"/register",
		"/register/**",
		"/webjars/**",
		"/resources/**",
		"/assets/**",
		"/css/**",
		"/js/**",
		"/*.css",
		"/*.js",
		"/favicon.ico",
		"/error"
	};

	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(auth -> {
			auth.requestMatchers(publicUrl).permitAll();
			auth.anyRequest().authenticated();
		});

		return http.build();
	}
}
