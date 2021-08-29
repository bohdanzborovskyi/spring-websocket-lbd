package com.zbodya.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zbodya.Service.RegisterService;

@RestController
public class RegisterController 
{
	@Autowired
	RegisterService service;
	
	
	@PostMapping("/register")
	public ResponseEntity createUser(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("authorities") String... authorities) 
	{
		service.createUser(userName, password,  authorities);
		return  ResponseEntity.status(HttpStatus.CREATED).body("User created!");
	}
	

	
}
