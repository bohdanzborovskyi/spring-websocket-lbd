package com.zbodya.ControllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.zbodya.Service.MessageService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DecimalControllerTest 
{
	@Autowired
	MockMvc mvc;

	@MockBean
	MessageService service;
	
	@Test
	public void testGetDecimal() throws Exception 
	{
		mvc.perform(MockMvcRequestBuilders
			.get("/api/decimal"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$").value(5));			
	}
	
	@Test
	public void testSetDecimal() throws Exception
	{
		mvc.perform(MockMvcRequestBuilders
				.put("/api/decimal")
				.param("decimal", "5"))								
				.andDo(print())				
				.andExpect(status().isOk());
	}
	
}
