package com.zbodya.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zbodya.Service.MessageService;

@RestController
public class MultiplierController 
{

	@PutMapping("api/multiplier")
	public void setMultiplier(@RequestParam("multi") int multi) 
	{
		MessageService.setMultiplier(multi);
	}
	
	@PreAuthorize("hasAuthority('MULTIPLIER_READ')")
	@GetMapping("api/multiplier")
	public ResponseEntity<Integer> getMultiplier() 
	{
		return new ResponseEntity<Integer>(MessageService.getMultiplier(),HttpStatus.OK);
	}
	
}
