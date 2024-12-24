package com.slobodanzivanovic.jobportal.services;

import com.slobodanzivanovic.jobportal.entity.Users;
import com.slobodanzivanovic.jobportal.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersService {

	private final UsersRepository usersRepository;

	public Users addNew(Users users) {
		users.setActive(true);
		users.setRegistrationDate(new Date(System.currentTimeMillis()));

		return usersRepository.save(users);
	}

	public Optional<Users> getUserByEmail(String email) {
		return usersRepository.findByEmail(email);
	}
}
