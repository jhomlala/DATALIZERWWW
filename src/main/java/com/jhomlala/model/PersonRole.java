package com.jhomlala.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "person_roles", catalog = "TeamCity_database")
public class PersonRole{

	private Integer personRoleID;
	private Integer personID;
	private String role;


	public PersonRole()
	{
	}
	
	
	@Id
	@Column(name = "personRoleID", unique = true, nullable = false, length = 12)
	public Integer getPersonRoleID() {
		return personRoleID;
	}



	public void setPersonRoleID(Integer personRoleID) {
		this.personRoleID = personRoleID;
	}


	@Column(name = "personID", unique = true, nullable = false, length = 12)
	public Integer getPersonID() {
		return personID;
	}


	public void setPersonID(Integer personID) {
		this.personID = personID;
	}


	@Column(name = "role", nullable = false, length = 60)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}