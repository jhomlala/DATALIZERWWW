package com.jhomlala.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhomlala.model.Person;
import com.jhomlala.model.PersonRole;


@Repository
public class PersonDaoImpl implements PersonDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public Person findById(int id)
	{
	List<Person> persons = new ArrayList<Person>();

	persons = sessionFactory.getCurrentSession().createQuery("from Person where id=?").setParameter(0,id)
			.list();

	if (persons.size()>0)
	{
		List <PersonRole> personRoles = new ArrayList<PersonRole>();
		personRoles = sessionFactory.getCurrentSession().createQuery("from PersonRole where personID=?").setParameter(0,id)
			.list();
	
		Person person = persons.get(0);
		person.setRoles(personRoles);
	
		return person;
	}
	else
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Person findByLogin(String name) {
		List<Person> persons = new ArrayList<Person>();

		persons = sessionFactory.getCurrentSession().createQuery("from Person where login=?").setParameter(0,name)
				.list();

		if (persons.size()>0)
		{
		
			Person person = persons.get(0);
			List <PersonRole> personRoles = new ArrayList<PersonRole>();
			personRoles = sessionFactory.getCurrentSession().createQuery("from PersonRole where personID=?").setParameter(0,person.getId())
					.list();
			person.setRoles(personRoles);
			return person;
		}
		
		return null;

	}
	

	
	

	
}
