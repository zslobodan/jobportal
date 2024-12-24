package com.slobodanzivanovic.jobportal.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recruiter_profile")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RecruiterProfile {

	@Id
	private int userAccountId;

	@OneToOne
	@JoinColumn(name = "user_account_id")
	@MapsId
	private Users userId;

	private String firstName;

	private String lastName;

	private String city;

	private String state;

	private String country;

	private String company;

	@Column(length = 64)
	private String profilePhoto;
}
