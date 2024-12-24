package com.slobodanzivanovic.jobportal.repository;

import com.slobodanzivanovic.jobportal.entity.RecruiterProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterProfileRepository extends JpaRepository<RecruiterProfile, Integer> {
}
