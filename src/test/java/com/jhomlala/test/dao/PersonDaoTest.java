package com.jhomlala.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jhomlala.config.AppConfig;
import com.jhomlala.config.ResourcesConfig;
import com.jhomlala.config.SecurityConfig;
import com.jhomlala.config.core.SpringMvcInitializer;
import com.jhomlala.dao.PersonDao;
import com.jhomlala.model.Person;
import com.jhomlala.model.PersonRole;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class,SecurityConfig.class,ResourcesConfig.class, SpringMvcInitializer.class })
@WebAppConfiguration
@Transactional
public class PersonDaoTest {

	@Autowired
	PersonDao personDao;
	
	@Test
	public void testFindByID()
	{
		//check if first User is loaded
		assertNotNull(personDao.findById(1));
		
		//check if return element is instance of Person
		assertEquals(personDao.findById(1).getClass(),Person.class);
		
		//check user data
		Person person = personDao.findById(1);
		assertEquals(person.getId(),1);
		assertEquals(person.getLogin(),"jhomlala");
		assertEquals(person.getPassword(),"$2a$10$pHHPyiI.fomy/TGd1hEHJuVLVx.bECmn60osUyHpVwCtfQxF3phdW");
		assertEquals(person.getRoles().get(0).getRole(),"ROLE_USER");
		
	}
	
	@Test
	public void testFindByLogin()
	{
		//check if first User is loaded
		assertNotNull(personDao.findByLogin("jhomlala"));
		
		//check if return element is instance of Person
		assertEquals(personDao.findByLogin("jhomlala").getClass(),Person.class);
		
		//check user data
		Person person = personDao.findByLogin("jhomlala");
		assertEquals(person.getId(),1);
		assertEquals(person.getLogin(),"jhomlala");
		assertEquals(person.getPassword(),"$2a$10$pHHPyiI.fomy/TGd1hEHJuVLVx.bECmn60osUyHpVwCtfQxF3phdW");
		assertEquals(person.getRoles().get(0).getRole(),"ROLE_USER");
		
	}
	
	
}
