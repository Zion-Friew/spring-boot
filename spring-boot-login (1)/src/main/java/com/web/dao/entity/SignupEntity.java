package com.web.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//POJO -2006
//POJI

@Entity
@Table(name="user_profiles_tbl")
public class SignupEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lid;
	@Column(length=255)
	private String username;
	private String password;
	private String name;
	private String email;
	private String gender;
	private String role;
	private String photo;

}
