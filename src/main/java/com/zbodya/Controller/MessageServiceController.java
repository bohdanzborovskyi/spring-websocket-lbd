package com.zbodya.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.zbodya.Service.MessageDTO;
import com.zbodya.Service.MessageService;

@Controller
public class MessageServiceController 
{
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@MessageMapping("/message")
	@SendTo("/msg/info")
	public MessageService getMessageInfo(MessageService message) 
	{
		return message;
	}
	
	@Scheduled(fixedRate = 1500)
	public void sendMessageService() 
	{
		MessageService message = MessageService.generateMessage();
		System.out.println(message.getMultiplier() + " " + message.getDecimalPlaces());
		MessageDTO mess = new MessageDTO(message);
		template.convertAndSend("/msg/info",mess);
	}

}
