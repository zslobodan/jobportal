package com.slobodanzivanovic.jobportal.services;

import com.slobodanzivanovic.jobportal.entity.JobSeekerProfile;
import com.slobodanzivanovic.jobportal.entity.RecruiterProfile;
import com.slobodanzivanovic.jobportal.entity.Users;
import com.slobodanzivanovic.jobportal.repository.JobSeekerProfileRepository;
import com.slobodanzivanovic.jobportal.repository.RecruiterProfileRepository;
import com.slobodanzivanovic.jobportal.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersService {

	private final UsersRepository usersRepository;
	private final JobSeekerProfileRepository jobSeekerProfileRepository;
	private final RecruiterProfileRepository recruiterProfileRepository;
	private final PasswordEncoder passwordEncoder;

	public Users addNew(Users users) {
		users.setActive(true);
		users.setRegistrationDate(new Date(System.currentTimeMillis()));
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		Users savedUser = usersRepository.save(users);

		int userTypeId = users.getUserTypeId().getUserTypeId();
		if (userTypeId == 1) {
			recruiterProfileRepository.save(new RecruiterProfile(savedUser));
		} else {
			jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
		}

		return savedUser;
	}

	public Optional<Users> getUserByEmail(String email) {
		return usersRepository.findByEmail(email);
	}
}
