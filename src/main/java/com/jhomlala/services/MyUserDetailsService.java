package com.jhomlala.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhomlala.dao.PersonDao;
import com.jhomlala.model.PersonRole;



@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private PersonDao personDao;

	@Transactional(readOnly=true)	
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
	
		com.jhomlala.model.Person user = personDao.findByLogin(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());

		System.out.println(user.getId());
		System.out.println(user.getLogin());
		return buildUserForAuthentication(user, authorities);
		
	}

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.jhomlala.model.Person user, List<GrantedAuthority> authorities) {
		return new User(user.getLogin(), user.getPassword(), true, true, true, true, authorities);
	} 

	public List<GrantedAuthority> buildUserAuthority(List <PersonRole> roles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (PersonRole personRole: roles) {
			setAuths.add(new SimpleGrantedAuthority(personRole.getRole()));
			System.out.println(personRole.getRole());
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
	


}