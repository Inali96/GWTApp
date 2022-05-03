package com.exmaple.email.client;

import java.io.Serializable;

public class Uzytkownicy  implements Serializable
{ 
	
	private int Id;
	String user;
	String passwd;
	String email;
	
	public String getuser()
	{
		return user;
	}
	public void setuser(String user) 
	{
		this.user =  user;
	}	
	public String getpasswd()
	{
		return passwd;
	}
	public void setahaslo(String passwd) 
	{
		this.passwd =  passwd;
	}	
	public String getemail()
	{
		return email;
	}
	public void setemail(String email) 
	{
		this.email =  email;
	}
	
	public Uzytkownicy(){};
	
	public Uzytkownicy(String login,String haslo,String email)
	{
		 this.login=login;
		 this.haslo=haslo;
		 this.email=email;
	}
	

}