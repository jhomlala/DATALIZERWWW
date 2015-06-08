package com.jhomlala.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Set;
@Entity
@Table( name = "person", catalog = "TeamCity_database" )

public class Person 
{
	private int id;
	private String login;
	private String password;
	private List <PersonRole> roles;

	public Person()
	{
		
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false, length = 45)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "login", nullable = false, length = 60)
	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password", nullable = false, length = 60)
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	

	@Transient
	public List<PersonRole> getRoles() {
		return roles;
	}

	public void setRoles(List<PersonRole> roles) {
		this.roles = roles;
	}


	
	
}
