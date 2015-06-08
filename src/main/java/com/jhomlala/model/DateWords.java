package com.jhomlala.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "refresh_date", catalog = "Words_database")



public class DateWords {

	private Integer id;
	private Timestamp date;
	
	
	
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false, length = 11)
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "date", nullable = false)
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}

	
	
	


	
	
}
