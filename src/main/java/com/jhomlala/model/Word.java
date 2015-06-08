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
@Table(name = "word_stats", catalog = "TeamCity_database")

public class Word{

	private int idStats;
	private String word;
	private int amount;

	public Word() {/**/}

	@Id
	@GeneratedValue
	@Column(name = "idStats", unique = true, nullable = false, length = 11)
	public int getIdStats() {
		return idStats;
	}

	public void setIdStats(int idStats) {
		this.idStats = idStats;
	}
	
	@Column(name = "amount", nullable = false, length = 11)
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Column(name = "word", nullable = false, length = 45)
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
}