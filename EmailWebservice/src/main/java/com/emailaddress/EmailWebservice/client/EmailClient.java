package com.emailaddress.EmailWebservice.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.emailaddress.EmailWebservice.bean.Email;



@Component
public class EmailClient {
	@Autowired
	private RestOperations restOperations;
	
	@SuppressWarnings("unchecked")
	public List<Email> getEmails(@Value("${email.service.url}")final String url)
	{
		return (List<Email>)restOperations.getForObject(url, Email.class);
	}

	public static int getUniqueEmails(@Value("${email.service.url}"+"${get.uniqueEmailAddresses}")final String url)
	{
		RestTemplate restTemplate= new RestTemplate();
		return restTemplate.getForObject(url, Integer.class);
	}
}
