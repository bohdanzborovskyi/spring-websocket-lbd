package com.zbodya.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{
	
	@Autowired
	InMemoryUserDetailsManager manager;


	@Override
	protected void configure(HttpSecurity http) throws Exception
	{	
		http.httpBasic().and().csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.PUT,"/api/decimal").hasAuthority("DECIMAL_WRITE")
			.antMatchers(HttpMethod.PUT,"/api/multiplier").hasAuthority("MULTIPLIER_WRITE")
			.antMatchers("/register").permitAll()
			.antMatchers("/api/number/**").hasAuthority("ADMIN")
			.antMatchers("/api/user").permitAll()
			.antMatchers("/api/user/enable").hasAuthority("ADMIN")
			.antMatchers("/api/user/disable").hasAuthority("ADMIN")
			.antMatchers("/api/user/delete").hasAuthority("ADMIN")
			.antMatchers("/api/user/update").hasAuthority("ADMIN")
			.and().formLogin();			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(manager);
	}
	
	@Bean
	public InMemoryUserDetailsManager getInMemoryUserDetailsManager() 
	{
		return new InMemoryUserDetailsManager();
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() 
	{
		return new BCryptPasswordEncoder();
	}
	
	
}
