package com.slobodanzivanovic.jobportal.repository;

import com.slobodanzivanovic.jobportal.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
