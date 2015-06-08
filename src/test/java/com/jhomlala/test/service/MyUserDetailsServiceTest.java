package com.jhomlala.test.service;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jhomlala.config.AppConfig;
import com.jhomlala.config.ResourcesConfig;
import com.jhomlala.config.SecurityConfig;
import com.jhomlala.config.core.SpringMvcInitializer;
import com.jhomlala.dao.WordsDao;
import com.jhomlala.model.PersonRole;
import com.jhomlala.model.Word;
import com.jhomlala.services.MyUserDetailsService;
import com.jhomlala.services.WordService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class,SecurityConfig.class,ResourcesConfig.class, SpringMvcInitializer.class })
@WebAppConfiguration
@Transactional
@EnableWebSecurity
public class MyUserDetailsServiceTest {

	@Autowired
	UserDetailsService userDetailService;
	
	

	
	@Test
	public void loadUserByUsernameTest()
	{
		//check if userDetailService return object
		assertNotNull(userDetailService.loadUserByUsername("jhomlala"));
		
		UserDetails user = userDetailService.loadUserByUsername("jhomlala");
		
		assertEquals(user.getUsername(),"jhomlala");
		assertEquals(user.getPassword(),"$2a$10$pHHPyiI.fomy/TGd1hEHJuVLVx.bECmn60osUyHpVwCtfQxF3phdW");
		
		assertEquals(user.getAuthorities().size(),1);
		
		for (Iterator iterator = user.getAuthorities().iterator(); iterator.hasNext();) {
	        
	        GrantedAuthority authority = (GrantedAuthority) iterator.next();
	        assertEquals(authority.getAuthority(),"ROLE_USER");
	    }
		
		User userAccount = (User) userDetailService.loadUserByUsername("jhomlala");
		
		assertEquals(userAccount.isAccountNonExpired(),true);
		assertEquals(userAccount.isAccountNonLocked(),true);
		assertEquals(userAccount.isCredentialsNonExpired(),true);
		assertEquals(userAccount.isEnabled(),true);
		
	}




	private List<GrantedAuthority> extracted(UserDetails user) {
		return (List<GrantedAuthority>) user.getAuthorities();
	}
}
