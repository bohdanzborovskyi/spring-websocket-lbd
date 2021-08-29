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
public class NumberControllerTest 
{

	@Autowired
	MockMvc mvc;

	@MockBean
	MessageService service;
	
	@Test
	public void testGetValues() throws Exception 
	{
		mvc.perform(MockMvcRequestBuilders
			.get("/api/number"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$[0]").value("red"))
			.andExpect(MockMvcResultMatchers.jsonPath("$[1]").value(5))
			.andExpect(MockMvcResultMatchers.jsonPath("$[2]").value(5));			
	}
	
	@Test
	public void testSetValues() throws Exception
	{
		mvc.perform(MockMvcRequestBuilders
				.put("/api/number")
				.param("decimal", "5")
				.param("multi", "5")
				.param("color", "red"))								
				.andDo(print())				
				.andExpect(status().isOk());
	}
	
}
