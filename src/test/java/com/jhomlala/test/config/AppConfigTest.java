package com.jhomlala.test.config;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jhomlala.config.AppConfig;
import com.jhomlala.config.ResourcesConfig;
import com.jhomlala.config.SecurityConfig;
import com.jhomlala.config.core.SpringMvcInitializer;
import com.jhomlala.model.Person;
import com.jhomlala.model.Word;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, SecurityConfig.class,
		ResourcesConfig.class, SpringMvcInitializer.class })
@WebAppConfiguration
@Transactional
public class AppConfigTest {

	@Autowired
	DataSource dataSource;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	HibernateTransactionManager manager;
	
	@Autowired
	InternalResourceViewResolver viewResolver;
	
	@Autowired
	CommonsMultipartResolver multipartResolver;
	
	@Test
	public void DatasourceTest() throws SQLException {
		assertNotNull(dataSource);
		assertNotNull(dataSource.getConnection());
	}

	@Test
	public void SessionFactoryTest() {
		assertNotNull(sessionFactory);
		assertNotNull(sessionFactory.getCurrentSession());

		// check sessionFactory if we can fetch some object
		List<Word> list = sessionFactory.getCurrentSession()
				.createCriteria(Word.class).list();

		assertTrue(list.size() > 0);
		assertEquals(list.get(0).getClass(), Word.class);
		assertEquals(list.get(0).getId(), 1);

		List<Person> persons = sessionFactory.getCurrentSession()
				.createQuery("from Person").list();
		
		assertTrue(persons.size() > 0);
		assertEquals(persons.get(0).getClass(),Person.class);
		assertEquals(persons.get(0).getId(),1);
		
	}
	
	@Test
	public void hibernateTransactionManagerTest()
	{
		assertNotNull(manager);
		assertEquals(manager.getClass(),HibernateTransactionManager.class);
	}
	
	@Test
	public void internalResourceViewResolverTest()
	{
		assertNotNull(viewResolver);
		assertEquals(viewResolver.getClass(),InternalResourceViewResolver.class);
		
	}
	
	@Test
	public void commonsMultipartResolverTest()
	{
		assertNotNull(multipartResolver);
		assertEquals(multipartResolver.getClass(),CommonsMultipartResolver.class);
	}
	
}
