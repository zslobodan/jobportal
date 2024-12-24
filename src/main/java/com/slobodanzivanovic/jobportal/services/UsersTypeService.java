package com.slobodanzivanovic.jobportal.services;

import com.slobodanzivanovic.jobportal.entity.UsersType;
import com.slobodanzivanovic.jobportal.repository.UsersTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsersTypeService {

	private final UsersTypeRepository usersTypeRepository;

	public List<UsersType> getAll() {
		return usersTypeRepository.findAll();
	}
}
