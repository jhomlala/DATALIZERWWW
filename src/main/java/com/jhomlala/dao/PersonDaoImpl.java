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
	
	
	@Override
	
	public int insert(Person person) 
	{
		Session session = sessionFactory.openSession();
		int id=0;
		 Transaction tx = null;
		 try {
			 if (findByLogin(person.getLogin())==null)
			 {
				 tx = session.beginTransaction();
				 session.save(person);
		     	 id = person.getId();
			 }
			 else return 1;
		     
		     tx.commit();
		 }
		 catch (Exception exc) {
		     if (tx!=null) tx.rollback();
		     
		 }
		 finally {
		     session.close();
		 }
		anotherInsert(person,id);
		return 0;
	}

	@SuppressWarnings("unchecked")
	private int anotherInsert(Person person,int id)
	{

		Session session = sessionFactory.openSession();
		 Transaction tx = null;
		 try {
			 if (findByLogin(person.getLogin())==null)
			 {
				 tx = session.beginTransaction();
			 		for (PersonRole role : person.getRoles())
			 		{
			 			role.setPersonID(id);
			 			session.save(role);
			 		}

		     
		     tx.commit();
			 }
			 else return 1;
		 }
		 catch (Exception e) {
		     if (tx!=null) tx.rollback();
		  
		 }
		 finally {
		     session.close();
		 }
		 
		 return 0;
	
		
	}

	
	

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
	
	@SuppressWarnings("unchecked")
	@Override
	public Person findByEmail(String email) {
		List<Person> persons = new ArrayList<Person>();

		persons = sessionFactory.getCurrentSession().createQuery("from Person where email=?").setParameter(0,email)
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
