package com.jhomlala.dao;

import java.math.BigInteger;
import java.util.List;

import com.jhomlala.model.Person;

public interface PersonDao {
	
	int insert(Person person);
	Person findById(int id);
	Person findByLogin(String name);
	Person findByEmail(String email);

	
}
