package com.emailaddress.EmailWebservice.bean;

public class Email {
	
	private String emailAddress;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Override
	public String toString()
	{
	    return this.emailAddress;
	}

}
