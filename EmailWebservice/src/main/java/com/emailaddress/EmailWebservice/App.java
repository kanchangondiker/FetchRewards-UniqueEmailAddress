package com.emailaddress.EmailWebservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emailaddress.EmailWebservice.bean.Email;
import com.emailaddress.EmailWebservice.client.EmailClient;



/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
	private static final Logger logger=LoggerFactory.getLogger(App.class);
	public static void main( String[] args )
	{
		System.out.println("HelloWord!");
	  SpringApplication.run(App.class,args);
	}
	@Autowired
	private EmailClient emailClient;
	public void run(String[] args) throws Exception
	{
	    List<Email> emails=(List<Email>) emailClient.getEmails("${email.service.url}");
	    logger.info("Response: {}",emails);
	    
	    int uniqueCount=emailClient.getUniqueEmails("${email.service.url}"+"${get.uniqueEmailAddresses}");
	    logger.info("End Response {}:",uniqueCount);
	}
}
