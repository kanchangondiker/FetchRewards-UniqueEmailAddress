package com.emailaddress.EmailWebservice.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emailaddress.EmailWebservice.bean.Email;



@RestController
public class EmailController {
	public static final String EMAIL_BASE_URI="/svc/v1/emails";
	public static final String GET_UNIQUE_EMAIL_ADDRESSES="/getAllUniqueEmails";
	List<Email> emailList;
	@RequestMapping(method = RequestMethod.GET, value= EMAIL_BASE_URI)
	public List<Email> getEmails()
	{
		emailList=new ArrayList<>();
		Email email1=new Email();
		email1.setEmailAddress("test.email@gmail.com");
		Email email2=new Email();
		email2.setEmailAddress("test.email+spam@gmail.com");
		Email email3=new Email();
		email3.setEmailAddress("testemail@gmail.com");
		emailList.add(email1);
		emailList.add(email2);
		emailList.add(email3);
		return emailList;
		
	}
	@RequestMapping(method = RequestMethod.GET, value= EMAIL_BASE_URI+GET_UNIQUE_EMAIL_ADDRESSES)
	public @ResponseBody int getUniqueEmails()
	{
		Set<String>  uniqueEmails=new HashSet<>();
		for(Email email : emailList) 
        {
            String[] splitOnAt = email.toString().split("@");
			String localName = splitOnAt[0];
			String[] splitOnPlus = localName.split("\\+");
			String nonIgnorableName = splitOnPlus[0];
			nonIgnorableName = nonIgnorableName.replaceAll("\\.", "");
			nonIgnorableName = nonIgnorableName + "@" + splitOnAt[1];
			uniqueEmails.add(nonIgnorableName);
        }
		emailList.clear();
        return uniqueEmails.size();
		
		
	}

}
