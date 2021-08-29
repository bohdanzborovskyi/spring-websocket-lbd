package com.zbodya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zbodya.Interceptor.ColorIndicatorInterceptor;

@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter 
{
	
	@Autowired
	ColorIndicatorInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) 
	{
	     
	      registry.addInterceptor(interceptor);
	 
	      
	   }
	
}
