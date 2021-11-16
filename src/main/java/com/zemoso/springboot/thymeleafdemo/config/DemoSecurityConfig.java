package com.zemoso.springboot.thymeleafdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("securityDataSource")
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use jdbc authentication ...
		auth.jdbcAuthentication().dataSource(securityDataSource);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		String role="ADMIN";

		http.authorizeRequests()
			.antMatchers("/").hasAnyRole(role,"INCHARGE")
			.antMatchers("/students/list").hasAnyRole(role,"INCHARGE")
			.antMatchers("/departments/list").hasAnyRole(role,"INCHARGE")
			.antMatchers("/").hasAnyRole(role,"INCHARGE")
			.antMatchers("/departments/showForm*").hasAnyRole(role)
			.antMatchers("/students/showForm*").hasAnyRole(role,"INCHARGE")
			.antMatchers("/students/save*").hasAnyRole("INCHARGE", role)
			.antMatchers("/departments/delete").hasRole(role)
			.antMatchers("/resources/**").permitAll()
			.and()
			.formLogin()
			.loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/logout")
				.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		
	}
		
}






