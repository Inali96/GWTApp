package com.exmaple.email.client;

import java.io.Serializable;

public class Email  implements Serializable
{ 

	private String id;
	String tytul;
	String nadawca;
	String tresc;
	String kategoria;
	String adresat;
	
	public String gettytul()
	{
		return tytul;
	}
	public void settytul(String tytul) 
	{
		this.tytul =  tytul;
	}	
	public String getadresat()
	{
		return adresat;
	}
	public void setadresat(String adresat) 
	{
		this.adresat =  adresat;
	}	
	public String getnadawca()
	{
		return nadawca;
	}
	public void setnadawca(String nadawca) 
	{
		this.nadawca =  nadawca;
	}
	public void settresc(String tresc) 
	{
		this.tresc =  tresc;
	}
	public String gettresc()
	{
		return tresc;
	}
	public void setid(String id) {
		
		this.id= id;
	}
	public String getid(String id) {
		
		return id;
	}
	public void setkategoria(String kategoria) 
	{
		this.kategoria =  kategoria;
	}
	public String getkategoria()
	{
		return kategoria;
	}

	public Email(){};
	
	public Email(String id,String tytul,String nadawca,String tresc,String kategoria,String adresat)
	{
		 this.id=id;
		 this.tytul=tytul;
		 this.nadawca=nadawca;
		 this.tresc=tresc;
		 this.kategoria=kategoria;
		 this.adresat=adresat;
	}
	

}