package com.jhomlala.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhomlala.model.Person;
import com.jhomlala.model.PersonRole;
import com.jhomlala.model.Word;

@Repository
public class WordsDaoImpl implements WordsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Word> getAll() {
		List<Word> words = new ArrayList<Word>();

		words  = sessionFactory.getCurrentSession().createCriteria(Word.class).list();
		
		return words;

	}

}
