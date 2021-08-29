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
public class DecimalController 
{
	@PutMapping("api/decimal")
	public void setDecimal(@RequestParam("decimal") int decimal) 
	{
		MessageService.setDecimalPlaces(Integer.valueOf(decimal));
	}

	@PreAuthorize("hasAuthority('DECIMAL_READ')")
	@GetMapping("api/decimal")
	public ResponseEntity<Integer> getDecimal()
	{
		return new ResponseEntity<Integer>(MessageService.getDecimalPlaces(),HttpStatus.OK);
	}
}
