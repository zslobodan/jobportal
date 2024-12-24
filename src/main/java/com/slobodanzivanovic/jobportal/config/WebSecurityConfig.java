package com.slobodanzivanovic.jobportal.config;

import com.slobodanzivanovic.jobportal.services.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

	private final CustomUserDetailsService customUserDetailsService;

	private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

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

		http.authenticationProvider(authenticationProvider());

		http.authorizeHttpRequests(auth -> {
			auth.requestMatchers(publicUrl).permitAll();
			auth.anyRequest().authenticated();
		});

		http.formLogin(form ->
				form.loginPage("/login")
					.permitAll()
					.successHandler(customAuthenticationSuccessHandler))
			.logout(logout -> {
				logout.logoutUrl("/logout");
				logout.logoutSuccessUrl("/");
			}).cors(Customizer.withDefaults())
			.csrf(csrf -> csrf.disable());

		return http.build();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		authenticationProvider.setUserDetailsService(customUserDetailsService);

		return authenticationProvider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
