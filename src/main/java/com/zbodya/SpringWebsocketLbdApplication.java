package com.zbodya;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.zbodya.Service.MessageService;
import com.zbodya.Service.RegisterService;

@SpringBootApplication
@EnableScheduling
public class SpringWebsocketLbdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebsocketLbdApplication.class, args);
	}
	
	@PostConstruct
	public void postContruct() 
	{
		MessageService message = MessageService.generateMessage();
		System.out.println(message.getValueOne() + " " + message.getValueTwo());
	}

	
// Dla testów muszą być 
//	@Bean 
//	public MessageService getMessageService() 
//	{
//		return new MessageService();
//	} 
//	
//	@Bean  
//	public RegisterService getRegisterService() 
//	{
//		return new RegisterService();
//	}
	


}
