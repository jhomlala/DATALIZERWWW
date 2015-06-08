package com.jhomlala.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

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
import com.jhomlala.services.DateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class,SecurityConfig.class,ResourcesConfig.class, SpringMvcInitializer.class })
@WebAppConfiguration
public class DateServiceTest {

	@Autowired
	DateService dateService;
	
	@Test
	public void getLastDateTest()
	{
				//result cant be null
				assertNotNull(dateService.getLastDate());
				
				//result must be instance of Timestamp
				assertEquals(dateService.getLastDate().getClass(),Timestamp.class);
				
				//date should be older than current date
				assertNotEquals(new Date().compareTo(dateService.getLastDate()),0);
	}
	
	
}
