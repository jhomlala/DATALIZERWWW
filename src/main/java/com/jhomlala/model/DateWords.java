package com.jhomlala.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "date", catalog = "TeamCity_database")

public class DateWords {

	private Integer iddate;
	private Timestamp date;
	
	@Id
	@GeneratedValue
	@Column(name = "iddate", unique = true, nullable = false, length = 11)
	
	@Column(name = "date", nullable = false)
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	public Integer getIddate() {
		return iddate;
	}
	public void setIddate(Integer iddate) {
		this.iddate = iddate;
	}
}
