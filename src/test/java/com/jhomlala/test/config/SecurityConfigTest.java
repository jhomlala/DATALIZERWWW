package com.jhomlala.test.config;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jhomlala.config.AppConfig;
import com.jhomlala.config.ResourcesConfig;
import com.jhomlala.config.SecurityConfig;
import com.jhomlala.config.core.SpringMvcInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, SecurityConfig.class,
		ResourcesConfig.class, SpringMvcInitializer.class })
@WebAppConfiguration
public class SecurityConfigTest {

	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	public void passwordEncoderTest()
	{
		assertNotNull(passwordEncoder);
		assertEquals(passwordEncoder.getClass(),BCryptPasswordEncoder.class);
	}
}
