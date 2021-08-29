package com.zbodya.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class RegisterService 
{
	@Autowired
	InMemoryUserDetailsManager manager;
	
	Map<String,UserDetails> disableUsers = new HashMap<>();
	
	public void createUser(String userName, String password, String...authorities) 
	{
		manager.createUser(User.withUsername(userName).password(new BCryptPasswordEncoder().encode(password)).authorities(authorities).build());
	}
	
	public void updateUser(String userName, String... authorities) 
	{
		UserDetails user = manager.loadUserByUsername(userName);		
		String name = user.getUsername();
		String password = user.getPassword();
		manager.deleteUser(userName);
		manager.createUser(User.withUsername(name).password(new BCryptPasswordEncoder().encode(password)).authorities(authorities).build());		
	}
	
	public void disableUser(String userName) 
	{
		disableUsers.put(userName, manager.loadUserByUsername(userName));
		manager.deleteUser(userName);
	}
	
	public void enableUser(String userName) 
	{
		manager.createUser(disableUsers.get(userName));
	}
	
	
	
	
}
