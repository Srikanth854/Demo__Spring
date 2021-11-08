package com.zemoso.springboot.thymeleafdemo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.zemoso.springboot.thymeleafdemo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
//setup variable to hold the properites
	@Autowired
	private Environment env;
	
// Set up a logger for diagnosis
	private Logger logger=Logger.getLogger(getClass().getName());
	
//define a bean for security data source
@Bean
public DataSource securityDataSource()
{
	//creaate connection pool
	ComboPooledDataSource securityDataSource= new ComboPooledDataSource();
	
	//set jdbc driver class
	try {
		securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
	} catch (PropertyVetoException exc) {
		// TODO Auto-generated catch block
		throw new RuntimeException(exc);
	}
	
	//log the connection props
	
	logger.info("====> jdbc.url="+env.getProperty("jdbc.url"));
	logger.info("====> jdbc.user="+env.getProperty("jdbc.user"));
	
	//set db connection props
	securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
	securityDataSource.setUser(env.getProperty("jdbc.user"));
	securityDataSource.setPassword(env.getProperty("jdbc.password"));
	
	
	//set connection pool props
	securityDataSource.setInitialPoolSize(
			getIntProperty("connection.pool.initialPoolSize"));
	securityDataSource.setMinPoolSize(
			getIntProperty("connection.pool.minPoolSize"));
	securityDataSource.setMaxPoolSize(	
			getIntProperty("connection.pool.maxPoolSize"));
	securityDataSource.setMaxIdleTime(
			getIntProperty("connection.pool.maxIdleTime"));
	
	
	return securityDataSource;
}
//need a helper method
//read environment property and convert to int

private int getIntProperty(String propName) {
	
	String propVal=env.getProperty(propName);
	
	//convert to int
	int intPropval=Integer.parseInt(propVal);
	return intPropval;
	
}

//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		configurer.enable();
//	}




}
