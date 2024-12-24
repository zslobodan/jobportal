package com.slobodanzivanovic.jobportal.repository;

import com.slobodanzivanovic.jobportal.entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerProfileRepository extends JpaRepository<JobSeekerProfile, Integer> {
}
