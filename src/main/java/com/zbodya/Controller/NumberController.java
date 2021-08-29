package com.zbodya.Controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.zbodya.Service.MessageService;

@RestController
public class NumberController
{
	@PutMapping("api/number")
	public void setValues(@RequestParam("decimal") int decimal, @RequestParam("multi") int multi, @RequestParam("color") String color) 
	{
		MessageService.setColor(color);
		MessageService.setDecimalPlaces(decimal);
		MessageService.setMultiplier(multi);
	}
	
	@GetMapping("api/number")
	public ResponseEntity<List<String>> getValues()
	{
		return new ResponseEntity<List<String>>(Lists.asList(MessageService.getColor(),
				new String[]{String.valueOf(MessageService.getDecimalPlaces()),String.valueOf(MessageService.getMultiplier())}),HttpStatus.OK);
	}
}
