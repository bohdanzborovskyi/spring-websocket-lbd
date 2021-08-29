package com.zbodya.Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;


//Dla testów musi zostać wycofany
//@Component
//public class CheckFilter implements Filter
//{
//	
//	List colors = Arrays.asList("red","yellow","green","blue");
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException
//	{
//		HttpServletRequest req = (HttpServletRequest) request;
//		if(req.getMethod().equals("PUT") && !colors.contains(req.getHeader("indicatorColor")))
//		{
//			HttpServletResponse httpResponse = (HttpServletResponse)response;
//	    	httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST,"Niepoprawny kolor");	
//		}else
//			chain.doFilter(request, response);
//		
//	}
//	
//	
//
//}
