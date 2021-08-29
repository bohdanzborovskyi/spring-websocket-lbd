package com.zbodya.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zbodya.Service.RegisterService;

@RestController
public class UserController 
{

	@Autowired
	InMemoryUserDetailsManager manager;
	
	@Autowired
	RegisterService  service;
	
	@GetMapping("/api/user")
	public ResponseEntity<? extends Object> getUser(@RequestParam String userName) 
	{
		User user = (User) manager.loadUserByUsername(userName);
		if(user!=null)
			return new ResponseEntity<User>(user,HttpStatus.OK);
		else 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nie istnieje użytkownika o podanym imieniu");
	}
	
	@PutMapping("/api/user/update")
	public ResponseEntity updateUserAuthority(@RequestParam String userName, @RequestParam("authorities") String... authorities)
	{
		service.updateUser(userName,authorities);
		return  ResponseEntity.status(HttpStatus.OK).body("User updated!");
	}
	
	@DeleteMapping("/api/user/delete")
	public ResponseEntity deleteUser(@RequestParam String userName) 
	{
		manager.deleteUser(userName);
		return  ResponseEntity.status(HttpStatus.OK).body("User deleted!");
	}
	
	@PutMapping("/api/user/disable")
	public ResponseEntity disableUser(@RequestParam String userName) 
	{
		service.disableUser(userName);
		return  ResponseEntity.status(HttpStatus.OK).body("User disabled!");
	}
	
	@PutMapping("/api/user/enable")
	public ResponseEntity enableUser(@RequestParam String userName) 
	{
		service.enableUser(userName);
		return  ResponseEntity.status(HttpStatus.OK).body("User enabled!");
	}

}
