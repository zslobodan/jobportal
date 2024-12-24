package com.slobodanzivanovic.jobportal.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "skills")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String experienceLevel;

	private String yearsOfExperience;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_seeker_profile")
	private JobSeekerProfile jobSeekerProfile;
}
