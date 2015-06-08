package com.jhomlala.test.dao;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

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
import com.jhomlala.dao.DateDao;
import com.jhomlala.dao.DateDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class,SecurityConfig.class,ResourcesConfig.class, SpringMvcInitializer.class })
@WebAppConfiguration
@Transactional
public class DateDaoTest {

	@Autowired
	DateDao dateDao;
	
	@Test
	public void getLastDate()
	{
		
		//result cant be null
		assertNotNull(dateDao.getLastDate());
		
		//result must be instance of Timestamp
		assertEquals(dateDao.getLastDate().getClass(),Timestamp.class);
		
		//date should be older than current date
		assertNotEquals(new Date().compareTo(dateDao.getLastDate()),0);
		
	}
}
