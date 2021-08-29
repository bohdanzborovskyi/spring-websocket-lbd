package com.zbodya.ControllerTest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.security.test.context.support.WithMockUser;

import com.zbodya.Service.RegisterService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllerTest 
{

	@Autowired
	InMemoryUserDetailsManager manager;
	
	@Autowired
	RegisterService  service;
	
	@Autowired 
	MockMvc mvc;
	
	
	@Before
	public void testCreateUserOne() throws Exception 
	{
		mvc.perform(MockMvcRequestBuilders
				.post("/register")
				.param("userName", "Jack2")
				.param("password", "1234")
				.param("authorities","ADMIN"))
				.andDo(print())
				.andExpect(status().isCreated());	
		
		System.out.println("________________________________");
		
		mvc.perform(MockMvcRequestBuilders
				.post("/register")
				.param("userName", "Jack3")
				.param("password", "1234")
				.param("authorities","ADMIN"))
				.andDo(print())
				.andExpect(status().isCreated());	
	}
	
	@WithMockUser(roles = "ADMIN")
	@Test
	public void testGetUser() throws Exception 
	{		
		mvc.perform(MockMvcRequestBuilders
				.get("/api/user")
				.param("userName", "Jack"))
				.andDo(print())				
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.username").value("Jack"));			
	}	

	
	@WithMockUser(authorities = "ADMIN")
	@Test
	public void testUpdateUser() throws Exception 
	{
		mvc.perform(MockMvcRequestBuilders
				.post("/register")
				.param("userName", "Jack")
				.param("password", "1234")
				.param("authorities","ADMIN"))
				.andDo(print())
				.andExpect(status().isCreated());	
		
		mvc.perform(MockMvcRequestBuilders
				.put("/api/user/update")
				.param("userName", "Jack")
				.param("authorities","DECIMAL_READ"))
				.andDo(print())
//				.andExpect(status().isBadRequest());
				.andExpect(status().isOk());
	}
	
	@WithMockUser(authorities = "ADMIN")
	@Test
	public void testDeleteUser() throws Exception 
	{
		mvc.perform(MockMvcRequestBuilders
				.delete("/api/user/delete")
				.param("userName", "Jack"))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
	@WithMockUser(authorities = "ADMIN")
	@Test
	public void testDisableUser() throws Exception 
	{
		mvc.perform(MockMvcRequestBuilders
				.put("/api/user/disable")
				.param("userName", "Jack"))
				.andDo(print())
				.andExpect(status().isOk());
//				.andExpect(status().reason(containsString("Niepoprawny kolor")));
	}
	
	@WithMockUser(authorities = "ADMIN")
	@Test
	public void testEnableUser() throws Exception 
	{
		mvc.perform(MockMvcRequestBuilders
				.put("/api/user/enable")
				.param("userName", "Jack"))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
}
