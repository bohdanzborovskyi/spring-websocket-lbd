package com.zbodya.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zbodya.Service.MessageService;

@Component
public class ColorIndicatorInterceptor extends HandlerInterceptorAdapter
{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 
	{
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("Indicator " + req.getHeader("indicatorColor"));
		if(req.getMethod().equals("PUT") && req.getHeader("indicatorColor")!=null)
		{
			MessageService.setColor(req.getHeader("indicatorColor").toString());
		}
		return true;
		
		
	}

	
}
