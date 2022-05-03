package com.exmaple.email.client;

import java.io.Serializable;

public class Message implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String message;
	private Integer message2;

	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message) 
	{
		this.message = message;
	}	

	public Integer getMessage2() 
	{
		return message2;
	}
	public void setMessage2(Integer message2) 
	{
		this.message2 = message2;
	}	
}
