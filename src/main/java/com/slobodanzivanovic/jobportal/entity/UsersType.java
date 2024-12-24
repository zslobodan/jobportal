package com.slobodanzivanovic.jobportal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users_type")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UsersType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userTypeId;

	private String userTypeName;

	@OneToMany(targetEntity = Users.class, mappedBy = "userTypeId", cascade = CascadeType.ALL)
	private List<Users> users;

	@Override
	public String toString() {
		return "UsersType{" +
			"userTypeId=" + userTypeId +
			", userTypeName='" + userTypeName + '\'' +
			'}';
	}
}
